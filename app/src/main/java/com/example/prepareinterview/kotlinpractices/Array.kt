fun main() {
    //p = [1,2,3,4,5,6,7]
    //k = 3
    //output = [5,6,7,1,2,3,4]
    val list = arrayListOf(1, 2, 3, 4, 5, 6, 7).toMutableList()
    val index = 3
    val newlis = ArrayList<Int>()

    newlis.addAll(list.subList(list.size - index, list.size))
    newlis.addAll(list.subList(0, list.size - index))
    println(newlis)
    //p = [0,2,0,4,0,6,7]
    //[2,4,6,7,0,0,0]
    val alist= arrayListOf(0,2,0,4,0,6,7).toMutableList()

}