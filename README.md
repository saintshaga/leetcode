# leetcode

除了代码主要记录两个方面：

1， 方案和思路

2， 代码实现的时候，犯了哪些小错误，要注意哪些方面

2018/03/27 **22.generate-parentheses**

思路想的有点不对

2018/03/27 **20.valid-parentheses**

犯了两个很低级的错误： stack.pop的时候，里面可能没有元素；map里面取元素比较的时候没有仔细考虑，取错了

2018/03/27 **17.letter-combinations-of-a-phone-number**

在递归到i=n的时候，应该是返回一个空串的数组，而不是空的数组

2018/03/21 **3.longest-substring-without-repeating-characters**

思路完全不对

2018/03/21 **5.Longest Palindromic Substring**

回文，忘记了最长公共子串的解法，思路也不对。

2018/03/20 **81.search-in-rotated-sorted-array-ii**

对于mid跟l相等的时候，这种情况不知道怎么处理

2018/03/20 **79.word-search**

没有考虑到一个元素只能使用一次的情况

2018/03/13 **45. Jump Game II**

没想到O(n)的复杂度，只有O(n^2)的解法

2018/03/08 **42.trapping-rain-water**

思路彻底没有想出来，解决方案是错的

2018/03/05 **31 Next Permutation**

思路对的，但是代码的边界考虑的不够健全

2018/03/05 **16 3Sum Closest**

大致的思路是对的，但是在判断要不要提早结束的时候，想错了。在想清楚之前，可以不过早的缩减分支，超时了再缩减分支

2018/03/01 **11.container-with-most-water.java**

medium的题目，看了solution之后写出来的


2018/02/28 **4.median-of-two-sorted-arrays**

hard的题目，没有做出来，虽然搞懂了大概的思路，但是边界条件没有搞懂，最终没有写出来
