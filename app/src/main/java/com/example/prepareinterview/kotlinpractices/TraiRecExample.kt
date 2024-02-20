import java.math.BigInteger

class TrailRecExample {
    tailrec fun getFibonnices(n:Int,a:BigInteger,b:BigInteger):BigInteger{
        return if(n==0) b
        else getFibonnices(n-1,a+b,a)
    }
}