class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    public static void divide(int arr[],int si,int ei) {
        //when single element is ther
        if(si>=ei){
            return;
        }
        int mid =si+(ei-si)/2;
        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr,si,mid,ei);


        
    }

    //si=starting index
    //ei=ending index
    public static void conquer(int arr[],int si,int mid ,int ei){
        //creating new array
        int merge[]=new int[ei-si+1];  // or arr.length
        int ind1=si;
        int ind2=mid+1;
        int x=0;         // index for merge array

        while(ind1<=mid&& ind2<=ei){
             if(arr[ind1]<=arr[ind2]){
                merge[x]=arr[ind1];
                x++;ind1++;
             }
             else{
                merge[x]=arr[ind2];
                x++;ind2++;
             }
        }
        while(ind1<=mid){
            merge[x]=arr[ind1];
                x++;ind1++;

        }
        while(ind2<=ei){
            merge[x]=arr[ind2];
                x++;ind2++; 
        }

        //copying the merge array in arr
        for(int i=0,j=si;i<merge.length;i++,j++){
            arr[j]=merge[i];
        }

    }
}