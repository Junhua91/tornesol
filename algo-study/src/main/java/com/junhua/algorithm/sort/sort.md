#### 1. 排序比较

|排序方式 |时间复杂度 |空间复杂度 |稳定性|其他|
|:--:|:--:|:--:|:--:|:--:|  
|冒泡排序|O(n^2)|O(1)|稳定||   
|选择排序|O(n^2)|O(1)|不稳定||  
|插入排序|O(n^2)|O(1)|稳定|常数项相比冒泡排序要少|  
|归并排序|O(n*logn)|O(n)|稳定||
|快速排序|O(n*logn)|O(logN)|不稳定(partition的过程就是不稳定的)|常数项小|
|堆排序|O(n*logn)|O(1)|不稳定||

#### 2. 归并排序
每一个划分的快都是排好序的，然后将两个划分好的快使用外排的方式合并成一个

#### 3. 快速排序

- 固定分割数  
使用数组的最后一个（target）数作为分割数：大于target的数放在右侧，小于target的数放在左侧，等于target的数放在中间。  
如果数组本身是有序的，那么使用快速排序的时间复杂度会变成O(n^2).
- 随机分割数
时间复杂度就是一个随机问题，长期期望来看是O(n*logn)

#### 4. 堆排序
- 完全二叉树 ( 从左到右来fill 树)

     1                     1
    ／ \                  ／
   2    3                2
  ／\   /               ／
 4   5 6               3
（完全二叉树）           （非完全二叉树）

- 可以用一维数组来抽象完全二叉树  
i：父节点；2i+1：左子节点，2i+2：右子节点
- 堆排序包含两个两个重要步骤 
 
a) heapInsert
```java
    public static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            SortUtils.swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
```
b) heapify 
```java
 public static void hepify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = (left + 1) < heapSize && (nums[left] < nums[left + 1]) ? left + 1 : left;
            largest = nums[index] < nums[largest] ? largest : index;
            if (index == largest) break;
            SortUtils.swap(nums, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }
```



#### 5. 工程排序
- 在样本量比较小的时候（小于60），采用时间复杂度较高的插入排序，因为插入排序的常数项比较小
- 在样本量较大的时候，采用n*logn的排序算法；如果排序的元素是基础类型，由于没有涉及到稳定性，采用常数项比较小的快速排序；
如果排序元素是其他类型，要兼顾排序的稳定性，因此要采用归并排序。









