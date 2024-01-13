package codingninjas;

import java.util.*;

public class PhoneDirectory {
    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr)
    {
        //    Write your code here.
        Collections.sort(contactList);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        for(String str : contactList){
            if(str.charAt(0) == queryStr.charAt(0)){
                list.add(str);
            }
        }
        if(list.size() == 0)
            return result;

        result.add(list);

        for(int i = 1 ; i<queryStr.length(); i++){
            ArrayList<String> plist = new ArrayList<>();
            for(String str : result.get(result.size() - 1)){
                if(i < str.length() && str.charAt(i) == queryStr.charAt(i)){
                    plist.add(str);
                }
            }
            if(plist.size() == 0) 
                return result;

            result.add(plist);
        }

        return result;
    }    
    public static void main(String[] args) {
        ArrayList<String> directory = new ArrayList<>();
        String[] list = new String[]{
            "aaabb", "babaa", "abaaa", "ababb", "babbb" 
        };
        for (String str : list)  directory.add(str);

        System.out.println(phoneDirectory(directory, "abbba"));

    }
}


