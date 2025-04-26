package codeforces.april26;
import java.util.*;
import java.io.*;

public class D {
    static final int MOD = 1_000_000_007;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            int[][] points = new int[k + 1][2];
            for (int i = 0; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken()) - 1;
                points[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }
            
            // Check if consecutive points are Manhattan distance 2 apart
            boolean possible = true;
            for (int i = 1; i <= k; i++) {
                int x1 = points[i-1][0], y1 = points[i-1][1];
                int x2 = points[i][0], y2 = points[i][1];
                if (Math.abs(x1 - x2) + Math.abs(y1 - y2) != 2) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                out.println(0);
                continue;
            }
            
            // Build segments and candidate cells
            Map<Integer, Integer> cellToId = new HashMap<>();
            List<int[]> segments = new ArrayList<>();
            List<List<Integer>> cellSegments = new ArrayList<>();
            int cellId = 0;
            
            for (int i = 0; i < k; i++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[i+1][0], y2 = points[i+1][1];
                int mx = (x1 + x2) / 2;
                int my = (y1 + y2) / 2;
                
                List<int[]> candidates = new ArrayList<>();
                if (x1 == x2) {
                    // Same row, columns differ by 2
                    candidates.add(new int[]{x1, (y1 + y2) / 2});
                } else if (y1 == y2) {
                    // Same column, rows differ by 2
                    candidates.add(new int[]{(x1 + x2) / 2, y1});
                } else {
                    // Diagonal case: two possible middle cells
                    candidates.add(new int[]{x1, y2});
                    candidates.add(new int[]{x2, y1});
                }
                
                for (int[] cell : candidates) {
                    int cx = cell[0], cy = cell[1];
                    int id = cx * m + cy;
                    if (!cellToId.containsKey(id)) {
                        cellToId.put(id, cellId++);
                        cellSegments.add(new ArrayList<>());
                    }
                    int cellIdx = cellToId.get(id);
                    cellSegments.get(cellIdx).add(segments.size());
                }
                segments.add(new int[]{x1, y1, x2, y2});
            }
            
            // Now model as bipartite graph between segments and cells
            int S = segments.size();
            int C = cellToId.size();
            int[] segmentChoice = new int[S]; // -1: unset, index of cell
            Arrays.fill(segmentChoice, -1);
            int[] cellUsed = new int[C]; // -1: unused, index of segment
            Arrays.fill(cellUsed, -1);
            
            Queue<Integer> queue = new LinkedList<>();
            for (int s = 0; s < S; s++) {
                int x1 = segments.get(s)[0], y1 = segments.get(s)[1];
                int x2 = segments.get(s)[2], y2 = segments.get(s)[3];
                List<int[]> candidates = new ArrayList<>();
                if (x1 == x2) {
                    candidates.add(new int[]{x1, (y1 + y2) / 2});
                } else if (y1 == y2) {
                    candidates.add(new int[]{(x1 + x2) / 2, y1});
                } else {
                    candidates.add(new int[]{x1, y2});
                    candidates.add(new int[]{x2, y1});
                }
                
                if (candidates.size() == 1) {
                    int[] cell = candidates.get(0);
                    int id = cell[0] * m + cell[1];
                    if (cellToId.containsKey(id)) {
                        int cid = cellToId.get(id);
                        if (cellUsed[cid] == -1) {
                            segmentChoice[s] = cid;
                            cellUsed[cid] = s;
                            queue.add(s);
                        } else {
                            possible = false;
                            break;
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            
            if (!possible) {
                out.println(0);
                continue;
            }
            
            // Process the queue
            while (!queue.isEmpty()) {
                int s = queue.poll();
                int cid = segmentChoice[s];
                // Check other segments that could use this cell
                for (int otherS : cellSegments.get(cid)) {
                    if (otherS == s) continue;
                    if (segmentChoice[otherS] == cid) {
                        possible = false;
                        break;
                    }
                    if (segmentChoice[otherS] != -1) continue;
                    
                    // Find another cell for otherS
                    int x1 = segments.get(otherS)[0], y1 = segments.get(otherS)[1];
                    int x2 = segments.get(otherS)[2], y2 = segments.get(otherS)[3];
                    List<int[]> candidates = new ArrayList<>();
                    if (x1 == x2) {
                        candidates.add(new int[]{x1, (y1 + y2) / 2});
                    } else if (y1 == y2) {
                        candidates.add(new int[]{(x1 + x2) / 2, y1});
                    } else {
                        candidates.add(new int[]{x1, y2});
                        candidates.add(new int[]{x2, y1});
                    }
                    
                    int remainingCell = -1;
                    for (int[] cell : candidates) {
                        int id = cell[0] * m + cell[1];
                        if (cellToId.containsKey(id)) {
                            int c = cellToId.get(id);
                            if (c != cid && cellUsed[c] == -1) {
                                if (remainingCell == -1) {
                                    remainingCell = c;
                                } else {
                                    remainingCell = -2; // multiple options
                                }
                            }
                        }
                    }
                    
                    if (remainingCell == -1) {
                        possible = false;
                        break;
                    } else if (remainingCell >= 0) {
                        segmentChoice[otherS] = remainingCell;
                        cellUsed[remainingCell] = otherS;
                        queue.add(otherS);
                    }
                }
                if (!possible) break;
            }
            
            if (!possible) {
                out.println(0);
                continue;
            }
            
            // Now find connected components in the remaining bipartite graph
            boolean[] visitedSegments = new boolean[S];
            boolean[] visitedCells = new boolean[C];
            long result = 1;
            
            for (int s = 0; s < S; s++) {
                if (segmentChoice[s] != -1 || visitedSegments[s]) continue;
                
                Queue<Integer> q = new LinkedList<>();
                q.add(s);
                visitedSegments[s] = true;
                int segmentCount = 0;
                int cellCount = 0;
                List<Integer> cellsInComponent = new ArrayList<>();
                
                while (!q.isEmpty()) {
                    int current = q.poll();
                    segmentCount++;
                    
                    int x1 = segments.get(current)[0], y1 = segments.get(current)[1];
                    int x2 = segments.get(current)[2], y2 = segments.get(current)[3];
                    List<int[]> candidates = new ArrayList<>();
                    if (x1 == x2) {
                        candidates.add(new int[]{x1, (y1 + y2) / 2});
                    } else if (y1 == y2) {
                        candidates.add(new int[]{(x1 + x2) / 2, y1});
                    } else {
                        candidates.add(new int[]{x1, y2});
                        candidates.add(new int[]{x2, y1});
                    }
                    
                    for (int[] cell : candidates) {
                        int id = cell[0] * m + cell[1];
                        if (cellToId.containsKey(id)) {
                            int cid = cellToId.get(id);
                            if (cellUsed[cid] == -1 && !visitedCells[cid]) {
                                visitedCells[cid] = true;
                                cellsInComponent.add(cid);
                                cellCount++;
                            }
                        }
                    }
                    
                    for (int cid : cellsInComponent) {
                        for (int neighborS : cellSegments.get(cid)) {
                            if (!visitedSegments[neighborS] && segmentChoice[neighborS] == -1) {
                                visitedSegments[neighborS] = true;
                                q.add(neighborS);
                            }
                        }
                    }
                }
                
                if (segmentCount > cellCount) {
                    result = 0;
                    break;
                } else if (segmentCount == cellCount) {
                    result = (result * 2) % MOD;
                } else {
                    result = (result * cellCount) % MOD;
                }
            }
            
            out.println(result);
        }
        out.close();
    }
}