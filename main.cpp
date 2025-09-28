#include <bits/stdc++.h>
using namespace std;

// Fenwick Tree (Binary Indexed Tree)
struct BIT {
    int n;
    vector<int> bit;
    BIT(int n) : n(n), bit(n + 1, 0) {}

    void add(int i, int val) { // 0-based index
        i++;
        while (i <= n) {
            bit[i] += val;
            i += i & -i;
        }
    }

    int sum(int i) { // prefix sum [0..i]
        i++;
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= i & -i;
        }
        return s;
    }

    int sum(int l, int r) { // range sum [l..r]
        if (l > r) return 0;
        return sum(r) - (l > 0 ? sum(l - 1) : 0);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) cin >> arr[i];

    vector<array<int, 3>> queries(q);
    vector<int> allVals;

    // store updates for compression
    for (int i = 0; i < q; i++) {
        char type;
        cin >> type >> queries[i][1] >> queries[i][2];
        if (type == '!') queries[i][0] = 1;
        else queries[i][0] = 2;

        if (queries[i][0] == 1) {
            allVals.push_back(queries[i][2]); // updated values
        }
    }

    // add initial array values
    allVals.insert(allVals.end(), arr.begin(), arr.end());

    // coordinate compression
    sort(allVals.begin(), allVals.end());
    allVals.erase(unique(allVals.begin(), allVals.end()), allVals.end());

    auto getIndex = [&](int x) {
        return (int)(lower_bound(allVals.begin(), allVals.end(), x) - allVals.begin());
    };

    // initialize counts
    vector<int> count(allVals.size(), 0);
    for (int x : arr) {
        count[getIndex(x)]++;
    }

    BIT bit(allVals.size());
    for (int i = 0; i < (int)count.size(); i++) {
        if (count[i]) bit.add(i, count[i]);
    }

    // process queries
    for (auto &query : queries) {
        if (query[0] == 1) {
            int k = query[1] - 1;
            int x = query[2];
            int prevIdx = getIndex(arr[k]);
            int newIdx = getIndex(x);
            arr[k] = x;
            bit.add(prevIdx, -1);
            bit.add(newIdx, 1);
        } else {
            int a = query[1], b = query[2];

            int l = (int)(lower_bound(allVals.begin(), allVals.end(), a) - allVals.begin());
            int r = (int)(upper_bound(allVals.begin(), allVals.end(), b) - allVals.begin()) - 1;

            if (l <= r) cout << bit.sum(l, r) << "\n";
            else cout << 0 << "\n";
        }
    }

    return 0;
}
