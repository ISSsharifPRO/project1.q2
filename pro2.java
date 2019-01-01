package java_final_project;
import java.util.Scanner;

public class pro2 {
    public static void main(String[] args) {
        String[] arr = read();
        for (int y=0; y<arr.length; y++){
            arr[y]=arr[y].trim();
        }
        if (cor_input(arr) && arr.length>1){
            System.out.println(javab(arr));
        }else System.out.println(0);
    }
    // two tags like <>...</>  --> true             <> or </>  -->false
    public static Boolean opcl(String strings){
        int open = 0;
        int close = 0;
        for (int j=0; j<strings.length(); j++){
            if (strings.charAt(j)=='<')
                open++;
            if (strings.charAt(j)=='>')
                close++;
        }
        if (open==2 && close==2)
            return true;
        else return false;
    }
    // two tags is equals if : <a> , </a>
    public static Boolean equals(String a , String b){
        String str = "</"+a.substring(1,a.length());
        if (str.equals(b))
            return true;
        else
            return false;
    }
    // to adding
    public static String[] add(String[] str , String s){
        String[] newstr = new String[str.length+1];
        for (int i=0; i<str.length; i++){
            newstr[i]=str[i];
        }
        newstr[str.length]=s;
        return newstr;
    }
    // to removing by index
    public static String[] remove(String[] str , int n){
        String[] re = new String[str.length-1];
        for (int i=0; i<n; i++){
            re[i]=str[i];
        }
        for (int i=n+1; i<str.length; i++){
            re[i-1]=str[i];
        }
        return re;
    }
    // to reading array from input
    public static String[] read(){
        String[] arr = new String[0];
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine();
        String oneone = one;
        arr=add(arr,one);
        do {
            one = sc.nextLine();
            arr=add(arr,one);
        }while (!equals(oneone,one));
        return arr;
    }
    // to printing
    public static void print(String[] str){
        for (int i=0; i<str.length; i++){
            System.out.println(str[i]);
        }
    }
    // to checking / is exist
    public static Boolean bsl(String str){
        Boolean b=false;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)=='/')
                b=true;
        }
        return b;
    }
    // main scopes
    public static String[] main_tg(String[] strings){
        String[] re = new String[0];
        String[] p = scope_fin(strings);
        for (int i=2; i<p.length-1; i+=4){
            if (!exist(re,p[i]) && !exist(re,p[i+1])){
                re=add(re,p[i]);
                re=add(re,p[i+1]);
            }
        }
        return re;
    }
   public static String[] rm2(String[] strings, int m, int n){
       String[] t = strings;
       int i=0, j=0;
       while (Integer.valueOf(strings[i]) != m){
           i++;
       }
       while (Integer.valueOf(strings[j]) != n){
           j++;
       }
       for (int k=i+1; k<=j; k++){
           t[k]=null;
       }
       int p=0;
       for (int k=0; k<strings.length; k++){
           if (strings[k]==null) {
               t = remove(t, k - p);
               p++;
           }
       }
       return t;
   }
    // to checking a string is exist in an array
    public static Boolean exist(String[] str, String p){
        Boolean b=false;
        for (int i=0; i<str.length; i++){
            if (str[i].equals(p))
                b=true;
        }
        return b;
    }
    //for getting scopes
    public static String[] scope(String[] strings){
        String[] re = new String[0];
        String[][] tags = tags(strings);
        while (tags[0].length>=2) {
            for (int i = 0; i < tags[0].length - 1; i++) {
                if (equals(tags[0][i],tags[0][i+1])) {
                    re=add(re,tags[1][i]);
                    re=add(re,tags[1][i+1]);
                    tags[0]=remove(tags[0],i);
                    tags[0]=remove(tags[0],i);
                    tags[1]=remove(tags[1],i);
                    tags[1]=remove(tags[1],i);
                }
            }
        }
        return re;
    }
    public static String[] scope1(String[] strings){
        String[] re = new String[0];
        String[][] tags = tags(strings);

            for (int i = 0; i < tags[0].length - 1; i++) {
                if (equals(tags[0][i],tags[0][i+1])) {
                    re=add(re,tags[1][i]);
                    re=add(re,tags[1][i+1]);
                    tags[0]=remove(tags[0],i);
                    tags[0]=remove(tags[0],i);
                    tags[1]=remove(tags[1],i);
                    tags[1]=remove(tags[1],i);
                }
            }

        return re;
    }
    //for getting tags
    public static String[][] tags(String[] strings){
        String[][] re = new String[2][0];
        for (int i=0; i<strings.length; i++){
            if (!opcl(strings[i])) {
                re[0] = add(re[0], strings[i]);
                re[1] = add(re[1],i+"");
            }
        }
        return re;
    }
    // to finding all tags scope
    public static String[] scope_fin(String[] strings){
        String[] sc = scope(strings);
        String[] re = new String[0];
        for (int i=0; i<sc.length-2; i+=2){
            for (int j=0; j<sc.length; j+=2){
               int m=Integer.valueOf(sc[i]);
                int n=Integer.valueOf(sc[j]);
                int mm=Integer.valueOf(sc[i+1]);
                int nn=Integer.valueOf(sc[j+1]);
                if (m>n && mm<nn){
                    re=add(re,m+"");
                    re=add(re,mm+"");
                    re=add(re,n+"");
                    re=add(re,nn+"");
                    break;
                }
            }
        }
        return re;
    }
    public static String[][] tgg(String[] strings){
        String[] p = main_tg(strings);
        String[][] re = new String[p.length/2][0];
        for (int y=0; y<=p.length-2; y+=2){
            for (int o=Integer.valueOf(p[y]); o<=Integer.valueOf(p[y+1]); o++){
                re[y/2]=add(re[y/2],o+"");
            }
        }
        return re;
    }
    // to getting <>--</> in any scope
    public static String[][] tags_bp(String[] strings){
        String[] p = main_tg(strings);
        String[] q = scope_fin(strings);
        String[][] tg = tgg(strings);
        for (int i=0; i<p.length-1; i+=2){
            for (int j=2; j<q.length-1; j+=4){
                if (q[j].equals(p[i]) && q[j+1].equals(p[i+1])){
                    tg[i/2]=rm2(tg[i/2],Integer.valueOf(q[j-2]),Integer.valueOf(q[j-1]));
                }
            }
        }
        return tg;
    }
    // to count repeated in array
    public static int repeat(String[] str){
       int re=0;
       String[] p = new String[0];
       for (int u=0; u<str.length; u++){
           if (!exist(p,str[u]))
               p=add(p,str[u]);
       }
       return str.length-p.length;
    }
    // to get by index
    public static String[] by_index(String[] strings,String[] index){
       String[] re = new String[0];
       for (int i=0; i<index.length; i++){
           String s = strings[Integer.valueOf(index[i])], ss="";
           int tt=0;
           while (s.charAt(tt)!='>'){
               ss+=s.charAt(tt);
               tt++;
           }
           re=add(re,ss+'>');
       }
       return re;
    }
    // to count repeated tags
    public static int javab1(String[] strings){
       int javab=0;
       String[][] t = tags_bp(strings);
       String[] p=new String[0];
       for (int i=0; i<t.length; i++){
           p=by_index(strings,t[i]);
           javab+=repeat(p);
           p=new String[0];
       }
       String[] pp = scope1(strings);
       String[] ppp =new String[0];
       for (int i=0; i<pp.length-1; i+=2){
           for (int j=Integer.valueOf(pp[i]); j<=Integer.valueOf(pp[i+1]); j++){
               ppp=add(ppp,j+"");
           }
           ppp=by_index(strings,ppp);
           //print(ppp);
           javab+=repeat(ppp);
           ppp=new String[0];
       }
       return javab;
    }

    // to count tags with out repeated
    public static int javab(String[] strings){
       int javab=0;
       for (int i=0; i<strings.length; i++){
           if (opcl(strings[i]))
               javab+=2;
           else if (!bsl(strings[i]))
               javab++;
       }
       return javab-javab1(strings);
    }

    /**
     *
     *  to checking input is correct?!!
     *  by down functions.
     *  output of them --> & --> to cor_input
     *
     */

    public static boolean cor_input(String[] strings){
        return bo_val(strings);
    }
    public static String get_val(String str){
        int i=0, j=0;
        while (str.charAt(i)!='>'){
            i++;
        }
        j=i;
        while (str.charAt(j)!='<'){
            j++;
        }
        return str.substring(i+1,j);
    }
    public static String[] value(String[] strings){
        String[] re=new String[0];
        for (int i=0; i<strings.length; i++){
            if (opcl(strings[i])) {
               re=add(re,get_val(strings[i]));
            }
        }
        return re;
    }
    public static boolean is_a_number(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean bo_val(String[] strings){
        String[] p= value(strings);
        Boolean b=true;
        for (int i=0; i<p.length; i++){
            if (p[i].equals("null") || p[i].equals("Null"))
                b=false;
            int d=0;
            for (int j=0; j<p[i].length(); j++){
                if (p[i].charAt(j)=='"')
                    d++;
            }
            if (!p[i].equals("true") && !p[i].equals("false") && d!=2 && !is_a_number(p[i]) && !p[i].equals(""))
                b=false;
        }
        return b;
    }
}
