package com.junhua.algorithm.datastructure.tree.avl;

public class AVLDemo {


    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(12);
        avlTree.insert(4);
        avlTree.insert(1);
        avlTree.insert(3);
        avlTree.insert(7);
        avlTree.insert(8);
        avlTree.insert(10);
        avlTree.insert(9);
        avlTree.insert(2);
        avlTree.insert(11);
        avlTree.insert(6);
        avlTree.insert(5);

         avlTree.delete(10);

        return;

    }
}
