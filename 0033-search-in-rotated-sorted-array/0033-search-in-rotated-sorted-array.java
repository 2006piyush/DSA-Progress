class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        int res = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>arr[arr.length-1]){
                if(arr[mid]<target){
                    low = mid+1;
                }
                else{
                    if(arr[0]>target){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
            else{
                 if(arr[mid]>target){
                    high = mid-1;
                }
                else{
                    if(arr[arr.length-1]<target){
                        high = mid-1;
                    }
                    else{
                         low = mid+1;
                    }
                }
            }
        }
        return res;
    }
}
