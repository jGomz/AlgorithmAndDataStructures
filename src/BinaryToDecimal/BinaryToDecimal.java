package BinaryToDecimal;

/*Code chalenge from blueprint
* Input: number < 10 ^ 9 - 7
* Output: number
*
* Example:
* Input: 13
* Transform to binary each number and concatenate: 111
* Now the result transform back to decimal
* Output:  */
public class BinaryToDecimal {

        // Function to convert decimal number n
        // to its binary representation
        // stored as an array arr[]
        static void decBinary(int arr[], int n)
        {
            int k = (int)(Math.log(n) / Math.log(2));

            while (n > 0)
            {
                arr[k--] = n % 2;
                n /= 2;
            }

            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[0]);
        }

        // Funtion to convert the number
        // represented as a binary array
        // arr[] into its decimal equivalent
        static int binaryDec(int arr[], int n)
        {
            arr = new int[]{1, 0, 1};
            int ans = 0;
            for (int i = 0; i < n; i++) {
                //ans += arr[i] << (n - i - 1);
                if(arr[i] == 1)
                    ans += Math.pow(2, (n - i - 1));
                System.out.println(ans);
            }
            return ans;
        }

        // Function to concatenate the binary
        // numbers and return the decimal result
        static int concat(int m, int n)
        {
            System.out.println("Math log m "+Math.log(m)/ Math.log(2));
            System.out.println("Math log n "+Math.log(n)/ Math.log(2));

            // Number of bits in both the numbers
            int k = (int)(Math.log(m) / Math.log(2)) + 1;
            int l = (int)(Math.log(n) / Math.log(2)) + 1;

            // Convert the bits in both the integers
            // to the arrays a[] and b[]
            int a[] = new int[k];
            int b[] = new int[l];

            // c[] will be the binary array
            // for the result
            int c[] = new int[k + l];
            decBinary(a, m);
            decBinary(b, n);

            // Update the c[] array
            int in = 0;
            for (int i = 0; i < k; i++)
                c[in++] = a[i];
            for (int i = 0; i < l; i++)
                c[in++] = b[i];

            // Return the decimal equivalent
            // of the result
            return (binaryDec(c, k + l));
        }

        // Driver code
        public static void main (String[] args)
        {
            int m = 1, n = 3;

            System.out.println(concat(m, n));
        }


    /* *** Code TEST ***
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("First Insert");
        Hashtable<Integer, ArrayList<String>> hasht = new Hashtable<>();
        hasht.put(1, arr);

        System.out.println(hasht.get(1).get(0));

        hasht.get(1).add("New String");

        System.out.println(hasht.get(1).get(1));
    }*/
}
