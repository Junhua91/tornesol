package com.junhua.tornesol.util.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree implements ITree {

    private Map<Integer, ITreeNode> treeNodeMap = new HashMap();
    private List<ITreeNode> treeNodeList = new ArrayList<ITreeNode>();


    public Tree(List<ITreeNode> nodeList) {
        initNodeMap(nodeList);
        initNodeList();
    }


    public List<ITreeNode> getNodeList() {
        return treeNodeList;
    }

    public List<ITreeNode> getRoots() {
        List<ITreeNode> roots = new ArrayList<>();
        if (treeNodeList.size() > 0) {
            treeNodeList.stream().forEach(node -> {
                int parentNodeId = node.getParentId();
                ITreeNode parentNode = treeNodeMap.get(parentNodeId);
                if (parentNode == null)
                    roots.add(node);
            });
        }
        return roots;
    }

    public ITreeNode getTreeNode(int nodeId) {
        return treeNodeMap.get(nodeId);
    }

    private void initNodeMap(List<ITreeNode> treeNodeList) {
        treeNodeList.forEach(node -> treeNodeMap.put(node.getNodeId(), node));

        treeNodeList.forEach(node -> {
            int parentNodeId = node.getParentId();
            if (parentNodeId == 0) {//FixMe check int 的默认值

            } else {
                ITreeNode parent = treeNodeMap.get(parentNodeId);
                if (parent != null) {
                    node.setParent(parent);
//                parent.addChild(node);
                    ITreeNode currentNode = treeNodeMap.get(node.getNodeId());
                    if (currentNode != null)
                        parent.addChild(currentNode);
                }
            }
        });
    }

    private void initNodeList() {
        if (treeNodeMap.size() != 0) {
            treeNodeMap.entrySet().stream().forEach(entry -> {
                ITreeNode node = entry.getValue();
                if (node.getParent() == null) {
                    treeNodeList.add(node);
                    treeNodeList.addAll(node.getAllChildren());
                }
            });
        }
    }
}
