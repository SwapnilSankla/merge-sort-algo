private const val GREEN_BACKGROUND = "\u001B[42m"
private const val GREY_BACKGROUND = "\u001B[47m"
private const val RESET_COLOR = "\u001B[0m"

fun main() {
    val list: List<Int> = listOf(2, 5, 3, 1, 8, 4, 9, 7)
    mergeSort(list)
}

fun mergeSort(list: List<Int>, tabs: Int = 0): List<Int> {
    IntRange(0, tabs).map { print("  ") }
    println("list: $list")
    val pivot = list.count() / 2
    if (pivot == 0) {
        return list.toList()
    }
    var list1 = if (list.count() == 1) list else list.take(pivot)
    var list2 = if (list.count() == 1) emptyList() else list.takeLast(list.count() - pivot)
    IntRange(0, tabs).map { print("  ") }
    println("Calling mergeSort on list $list1")
    list1 = mergeSort(list1, tabs + 1)
    IntRange(0, tabs).map { print("  ") }
    println("Calling mergeSort on list $list2")
    list2 = mergeSort(list2, tabs + 1)
    val sorted = sort(list1, list2)
    IntRange(0, tabs).map { print("  ") }
    println("Calling sort on $list1 and $list2")
    IntRange(0, tabs).map { print("  ") }
    println("$GREEN_BACKGROUND $GREY_BACKGROUND Sorted list: $sorted$RESET_COLOR")
    println()
    return sorted
}

private fun sort(list1: List<Int>, list2: List<Int>, sortedList: MutableList<Int> = mutableListOf()): List<Int> {
    if (list1.isEmpty() && list2.isEmpty())
        return sortedList
    if (list1.isEmpty() && list2.isNotEmpty()) {
        sortedList.addAll(list2)
        return sort(list1, emptyList(), sortedList)
    } else if (list1.isNotEmpty() && list2.isEmpty()) {
        sortedList.addAll(list1)
        return sort(emptyList(), list2, sortedList)
    }
    return if (list1[0] < list2[0]) {
        sortedList.add(list1[0])
        sort(list1.drop(1), list2, sortedList)
    } else {
        sortedList.add(list2[0])
        sort(list1, list2.drop(1), sortedList)
    }
}

/*
  list: [2, 5, 3, 1, 8, 4, 9, 7]
  Calling mergeSort on list [2, 5, 3, 1]
    list: [2, 5, 3, 1]
    Calling mergeSort on list [2, 5]
      list: [2, 5]
      Calling mergeSort on list [2]
        list: [2]
      Calling mergeSort on list [5]
        list: [5]
      Calling sort on [2] and [5]
        Sorted list: [2, 5]

    Calling mergeSort on list [3, 1]
      list: [3, 1]
      Calling mergeSort on list [3]
        list: [3]
      Calling mergeSort on list [1]
        list: [1]
      Calling sort on [3] and [1]
        Sorted list: [1, 3]

    Calling sort on [2, 5] and [1, 3]
      Sorted list: [1, 2, 3, 5]

  Calling mergeSort on list [8, 4, 9, 7]
    list: [8, 4, 9, 7]
    Calling mergeSort on list [8, 4]
      list: [8, 4]
      Calling mergeSort on list [8]
        list: [8]
      Calling mergeSort on list [4]
        list: [4]
      Calling sort on [8] and [4]
        Sorted list: [4, 8]

    Calling mergeSort on list [9, 7]
      list: [9, 7]
      Calling mergeSort on list [9]
        list: [9]
      Calling mergeSort on list [7]
        list: [7]
      Calling sort on [9] and [7]
        Sorted list: [7, 9]

    Calling sort on [4, 8] and [7, 9]
      Sorted list: [4, 7, 8, 9]

  Calling sort on [1, 2, 3, 5] and [4, 7, 8, 9]
    Sorted list: [1, 2, 3, 4, 5, 7, 8, 9]


 */