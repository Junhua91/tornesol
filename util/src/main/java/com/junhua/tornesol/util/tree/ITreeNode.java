package com.junhua.tornesol.util.tree;

import java.util.List;

interface ITreeNode {

    int getNodeType();

    int getNodeId();

    String getNodeName();

    int getParentId();

    List<ITreeNode> getChildren();

    List<ITreeNode> getAllChildren();

    void addChild(ITreeNode child);

    ITreeNode getParent();

    void setParent(ITreeNode parent);
}
