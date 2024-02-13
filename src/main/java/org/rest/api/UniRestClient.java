package org.rest.api;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.*;

public class UniRestClient {

    @Test
    public static void getHttpResponse() throws InvalidProtocolBufferException {
        int n=18;
        int[] coins={7,5,1};
        int numbers=findMinimumCoins(n,coins);
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
       // int n=lengthOfLongestINcreasingSequence(nums);
        String s="abcdefgh";
        String d=s.substring(0,1);

        Response response = RestAssured.given().when().get("apiUrl");
        String jres=response.getBody().asString();
        JsonFormat.parser().ignoringUnknownFields().merge(jres,null);


        RestAssured.baseURI="http://dash-cart.com";

        Map<String,String> header=new HashMap<>();
        header.put("content-type","json");
        header.put("tid","TID");

        Map<String,String> queryParam=new HashMap<>();
        queryParam.put("param1","value1");

        String requestBody="{\"key1\":\"value1\"}";

        Response qresponse=RestAssured.given()
                .headers(header)
                .contentType("json")
                .queryParams(queryParam)
                .pathParams("id","123")
                .body(requestBody)
                .post("/instamart");










        //url
//        String romanValue=convertToRoman(500);
//        RestAssured.baseURI="url";
//
//        // headers
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(12);
//        arrayList.add(34);
//        arrayList.add(67);
//        arrayList.add(90);
//
//       int result= findPages(arrayList,4,2);
//        // Specify the base URL to the RESTful web service
//        RestAssured.baseURI = "https://demoqa.com";
//        // Get the RequestSpecification of the request to be sent to the server.
//        RequestSpecification httpRequest = RestAssured.given();
//        // specify the method type (GET) and the parameters if any.
//        //In this case the request does not take any parameters
//        Response response = httpRequest.request(Method.GET, "/BookStore/v1/Books");
//        Response response2= httpRequest.get("/BookStore/v1/Books");
//        // Print the status and message body of the response received from the server
//
//        httpRequest=httpRequest.queryParams(null);
//        System.out.println("Status received => " + response.getStatusLine());
//        System.out.println("Response=>" + response.prettyPrint());
    }
    static int lengthOfLIS(int[] nums) {
        // Binary search approach
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        // Initialize the answer list with the
        // first element of nums
        ans.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > ans.get(ans.size() - 1)) {
                // If the current number is greater
                // than the last element of the answer
                // list, it means we have found a
                // longer increasing subsequence.
                // Hence, we append the current number
                // to the answer list.
                ans.add(nums[i]);
            } else {
                // If the current number is not
                // greater than the last element of
                // the answer list, we perform
                // a binary search to find the smallest
                // element in the answer list that
                // is greater than or equal to the
                // current number.

                // The binarySearch method returns
                // the index of the first element that is not less than
                // the current number.
                int low = Collections.binarySearch(ans, nums[i]);

                // We update the element at the
                // found position with the current number.
                // By doing this, we are maintaining
                // a sorted order in the answer list.
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, nums[i]);
            }
        }

        // The size of the answer list
        // represents the length of the
        // longest increasing subsequence.
        return ans.size();
    }


    public static boolean increasingTriplet2(int[] input){
        int[] leftMin=new int[input.length];
        leftMin[0]=input[0];
        for (int i = 1; i < input.length; i++) {
            leftMin[i]=Math.min(leftMin[i-1],input[i]);
        }
        int lastValue=input[input.length-1];
        for (int i = input.length-1; i >0 ; i--) {
            if (input[i]>leftMin[i] && leftMin[i]<lastValue){
                return true;
            }
            lastValue=Math.max(lastValue,input[i]);

        }
        return false;
    }

    //{10, 22, 9, 33, 21, 50, 41, 60};  // 10,22,33,50,60 - 5
    // 1, ,1   1,  1,  1,  1,  1,  1
    static int lengthOfLongestINcreasingSequence(int[] nums){
        int result=1;
        int[] maxCount=new int[nums.length];
        for (int i = 0; i <maxCount.length ; i++) {
            maxCount[i]=1;
        }
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j] && maxCount[i]<maxCount[j]+1){
                    maxCount[i]=maxCount[j]+1;
                }

            }
        }
        for (int i = 0; i < maxCount.length; i++) {
            if(maxCount[i]>result){
                result=maxCount[i];
            }
        }


        return result;
    }

    // {7,5,1} 18
    static int findMinimumCoins(int totalCount,int[] coins){
        int[] dp=new int[totalCount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        if (totalCount==0) return 0;
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i <coins.length ; i++) {
            if(totalCount-coins[i]>=0){
                int subAns=findMinimumCoins(totalCount-coins[i],coins);
                if(subAns!=Integer.MAX_VALUE && ans>subAns+1){
                    ans=subAns+1;
                }

            }
        }
        return ans;
    }
    static int findMaxAre(int[] input){
        int maxArea=1;
        List<Integer> subArray=new ArrayList<>();
        for (int i = 0; i < input.length ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(input[i]<input[j]){
                    int subMax=1;
                    if(subMax<maxArea){
                        maxArea += subMax;
                    }
                }
            }

        }
        return maxArea;
    }

    static int commonNumber(List<Integer> input){
        input.stream().sorted();
        return input.get(0);
    }

    public static List<String> longestSubstring(String input1){
        char[] input=input1.toCharArray();
        List<String> result=new ArrayList<>();
        int inputLength=input.length;
        String answer="";
        String subString="";
        for (int i = 0; i <inputLength ; i++) {

            for (int j = i; j <inputLength ; j++) {

                if(!subString.contains(String.valueOf(input[j]))) {
                    subString += input[j];
                }  else
                {
                    break;
                }
            }
            if(answer.length()<subString.length()){
                result.clear();
                answer=subString;
                result.add(answer);
                subString="";
            }
            if( answer.length()==subString.length()){
                answer=subString;
                result.add(answer);
                subString="";
            }

        }
        return result;

    }
    public static List<String> longestSubstringsWithoutRepeating(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        int n = s.length();
        int start = 0, end = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        List<String> longestSubstrings = new ArrayList<>();

        while (end < n) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;
                if (end - start > maxLength) {
                    maxLength = end - start;
                    longestSubstrings.clear(); // Clear previous substrings
                    longestSubstrings.add(s.substring(start, end));
                } else if (end - start == maxLength) {
                    longestSubstrings.add(s.substring(start, end));
                }
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return longestSubstrings;
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;

        int n = nums.length;
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];

        // Find the smallest element from the left for each index
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        int rightMax = Integer.MAX_VALUE;

        // Check if there is a number greater than the current number to its right
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > leftMin[i] && nums[i] < rightMax) {
                return true;
            }
            rightMax = Math.min(rightMax, nums[i]);
        }

        return false;
    }



    //  increasingTriplet(new int[]{97,98,99,54,58,29,35,12,38,5,1});


    //{10, 22, 9, 33, 21, 50, 41, 60};  // 10,22,33,50,60 - 5
    // 1, ,1   1,  1,  1,  1,  1,  1



    public static List<Integer> getClosestNumber(int[] input, int length){
        List<Integer> result=new ArrayList<>();
        int minimum=1000;
        int num1=0,num2=0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                int submin=Math.abs(input[i]-input[j]);
                if(submin<minimum && j!=i){
                    minimum=submin;
                    num1=input[i];
                    num2=input[j];
                }

            }
        }
        result.add(num1);
        result.add(num2);
        return result;

    }




    public static String isFunnyString(String input){
        boolean status=false;
        int[] asciiValue1=new int[input.length()];
        int[] asciiValue2=new int[input.length()];
        for (int i = 0; i <input.length() ; i++) {
            asciiValue1[i]=input.charAt(i);
            asciiValue2[asciiValue2.length-1-i]=input.charAt(i);
        }
        for (int i = 0; i <asciiValue1.length-1 ; i++) {
            //1,3,24,26
            int lastIndex =asciiValue1.length-1;
            if((asciiValue1[i+1]-asciiValue1[i]) == (asciiValue1[lastIndex-i]-asciiValue1[lastIndex-1-i])){
                status=true;
            }
            else return "Not Funny";

        }

//        for (int i = 0; i <asciiValue1.length-1 ; i++) {
//            if(Math.abs(asciiValue1[i+1]-asciiValue1[i]) == Math.abs(asciiValue2[i+1]-asciiValue2[i])){
//                status=true;
//            }
//            else return "Not Funny";
//        }
        return status? "Funny" : "Not Funny";
    }

    private static void extracted() {
        String jsonData = "{\"employee\":[{\"name\":\"A\",\"rank\":2,\"Score\":300},{\"name\":\"C\",\"rank\":1,\"Score\":500},{\"name\":\"D\",\"rank\":1,\"Score\":450},{\"name\":\"M\",\"rank\":7,\"Score\":200}]}";
        try {
            // Parse JSON to EmployeeListResponse
            ObjectMapper mapper = new ObjectMapper();
            EmployeeListResponse employeeListResponse = mapper.readValue(jsonData, EmployeeListResponse.class);

            // Get List of Employees
            List<Employee> employees = employeeListResponse.getEmployees();

            // Sort employees based on rank and score
            Collections.sort(employees, new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    if (e1.getRank() != e2.getRank()) {
                        return Integer.compare(e1.getRank(), e2.getRank());
                    } else {
                        return Integer.compare(e1.getScore(), e2.getScore());
                    }
                }
            });
            Collections.sort(employees, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    if(o1.getRank()!=o2.getRank()) {
                        return Integer.compare(o1.getRank(), o2.getRank());
                    }
                    else {
                        return Integer.compare(o2.getScore(),o2.getScore());
                    }
                }
            });

            // Print List of Employees
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




