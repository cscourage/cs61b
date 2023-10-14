## cs61b
本仓库为个人自学UCBerkeley cs61b时的所有资料仓库

## statement
cs61b作为UCBerkeley的数据结构与算法课程，全面地讲述了各种经典的数据结构和算法，主讲教授Josh Hug也会经常性地从学生的角度带着我们编写代码并发现容易出错的地方，Josh Hug在课上还会拿身边的例子来说明数据结构和算法，比如讲bag的时候拿起了自己的大袜子，而且课上也会涉及到一些我们国家的东西，真的是最最可爱的老师！！！课程slides中也会包含很多动画给我们展示算法的一步步流程，extremely animated、explict and straightforward.

在学完本课程之后，你一定会对各种经典数据结构和算法的设计有比较深入的了解，即使在一段时间没有接触并且忘记了其中的实现细节之后，只要你再次查阅相应资料，你一定能在非常短时间内就能又重新掌握设计的几乎所有细节以及为什么这么处理的原因；同时在学完本课程之后，你会对递归和类的思想有更加深入地把握，能很好地理解面向对象的思想以及能够让你自信地迈出"递归的信仰之跃"；而且，你对自己的代码风格也会有很大的进步，gradescope评分的有一项标准就是检查代码风格；最后，学完本课程会很大地提高你利用抽象的能力，比如在使用c++的stl中的很多数据结构和算法时，你基本上能够知道它的内部大概是怎么实现的了，于是能够根据我们的需要直接利用stl提供的抽象直接使用它即可，这在我后面学习CS106L时深有体会，当然这只是其中一个例子。

## 课程安排
课程主要分为三个大的板块进行：

第一个月保姆级地教你Java程序设计、git的使用、在命令行中编写编译和运行Java程序、IDEA的使用以及循序渐进地教你怎样设计数组和链表（比如为什么要嵌套类、为什么要在头部加一个sentinel node、为什么要设计双向链表或者循环链表等等），其中对于Java的程序设计还涉及到了一些industry的风格；

第二个月则从时间复杂度的渐进表示法开始，到算法时间复杂度的分析，然后讲到摊销amortization（resize()的思想等），再过渡到并查集Disjoint Sets、二叉搜索树BST、B树、红黑树(LLRB)、哈希表hash table、堆和优先级队列、前缀树Trie、四叉树QuadTree、KDTree等，然后从树的遍历开始过渡到图的表示、前序pre-order中序in-order后序post-order层序遍历、宽度优先搜索BFS、深度优先搜索DFS；

第三个月则讲述最小路径Dijkstra、最小生成树Prim和Kruskal、启发式A*、拓扑排序、DAG、Reductions and Decompositon，再过渡选择排序、堆排序、归并排序、插入排序、快速排序、shell排序、快速选择以及基于比较的排序算法的最优下界，再到基数排序(Counting sort、LSD、MSD)，再到最后的哈夫曼压缩，中间还穿插一些软件工程(software engineering)；

## work load
本仓库用的是spring2018的gradescope，所以是基于spring2018的版本完成的，gradescope进入码详情在下面的官网上可以找到，这也是目前cs61b资料全部公开的高质量版本，虽然你感觉2018spring会不会老了一点，但是事实上并不会，其中的很多hw、lab、project都十分的高质量，而且还能给你提供自动评分平台！！！gradescope的使用详情见课程主页网站的环境配置实验。

该课程质量是出了名的高，但同时各资料的选择也相应地比较杂和乱，本人在学习过程中，lecture第一个月的部分看的是2018spring的版本，第二个月的部分由于2018spring不是录播了声音也不太清晰，就换成了2019sping的版本，然后第三个月的部分由于涉及到一些software engineering的内容，所以直接跟进到了2023spring的版本。不过三个版本的课程都是Josh Hug主讲的，这真的是我见过的目前讲数据结构和算法最好的老师。

本课程work load还是比较大的，特别是当你是真正地刚开始接触数据结构与算法，因为如果你想老老实实地认真学的话，textbook的阅读量 + lecture的观看 + discussion + lab + hw + project 这一套学下来，是需要花相当大的功夫的，个人建议如果想真正打好基础的话，不建议跳过任何一个步骤，当然如果时间和学校work load不允许的话还是可以自行筛选的，这样学下来你对国外课程的适应能力会显著增强，对数据结构与算法的philosophy会有扎实的理解。

## 本仓库包含内容

本仓库中分为两个分支，一个是master，另一个是hug61b。master包含实现的作业，hug61b包含课上跟着demo的代码，以及各种数据结构自己写的实现，放在code/algori下（这个课上是没有教具体代码实现的，留给了我们学生自己去实现，虽然Princeton的algs4中有所有的实现，因为Josh Hug之前是在Princeton工作的，后面来了UCBerkeley，但是有些细节以及处理方式还是和algs4中的代码不一样，所以还是在参考algs4的情况下自己再实现是最好的，这样也可以加深理解）

对于作业部分，本仓库完成了lab1、lab2、lab3、lab9、lab10、lab11、lab12、lab13、lab14、hw1、hw2、hw3、project0、project1，且均满分通过，其余的小部分作业由于时间和学校本身的work load关系未继续完成。

![image](https://github.com/cscourage/cs61b/assets/110170603/c21b16a3-5818-4fad-a3b1-0b1fa9e9b3c5)


## 后续进阶
如果学完这门课就把它放到一边了，那么其中的很多内容在一段时间之后还是会忘记的，所以个人建议有兴趣的话再了解一些更高级的算法或者可以开始刷题来训练自己的代码能力。


## 相关资料网址
spring2018 website: https://sp18.datastructur.es/

spring2019 website: https://sp19.datastructur.es/

spring2023 website: https://sp23.datastructur.es/

旧版textbook: https://joshhug.gitbooks.io/hug61b/content/

新版textbook: https://cs61b-2.gitbook.io/cs61b-textbook/

课程视频可以在课程官网上或者textbook中穿插有，但需要魔法访问，这里给出b站搬运链接：

sp18 lecture: https://www.bilibili.com/video/BV1qt411W7dh/?spm_id_from=333.337.search-card.all.click&vd_source=2311b09f2e2b56314bb3f9e7539ba122

sp19/fa20 lecture: https://www.bilibili.com/video/BV1EJ411n72e?p=1&vd_source=2311b09f2e2b56314bb3f9e7539ba122

sp23: 自行魔法

sp18 gradescope entry code：MNXYKX；sp18的永久开放(虽然还有76年)，其他版本的有的暂时开放，有的不开放，自行搜索。
