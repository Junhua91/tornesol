package com.junhua.tornesol.util.tree;


import java.util.List;

/**
 * 定义tree拥有的方法
 */
public interface ITree {


    List<ITreeNode> getNodeList();

    List<ITreeNode> getRoots();

    ITreeNode getTreeNode(int nodeId);
}
