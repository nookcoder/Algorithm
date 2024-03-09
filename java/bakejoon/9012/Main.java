import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String vps = br.readLine();
            if(isVps(vps) == 0) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int isVps(String vpsString) {
        char[] vpsChars = vpsString.toCharArray();
        int size = 0;

        for(char v: vpsChars) {
            if(size == 0) {
                vpsChars[size++] = v;
            } else {
                if(v == ')' && vpsChars[size-1] == '(') {
                    vpsChars[size--] = '\n';
                } else {
                    vpsChars[size++] = v;
                }
            }
        }
        return size;
    }
}