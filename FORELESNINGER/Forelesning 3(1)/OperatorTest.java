class OperatorTest {
    public static void main(String[] args){
        int tall = 2;
        tall++;
        tall--;
        System.out.println(tall);
        tall+=5;
        tall*=2;
        tall%=3;
        System.out.println(tall);
        int a = 10;
        int b = 20;
        int c = b % a;
        a++;
        b++;
        c += a;
        a *= c;
        b--;
        c /= 2;
        c %= 2;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }
}