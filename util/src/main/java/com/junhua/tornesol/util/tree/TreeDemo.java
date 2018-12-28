package com.junhua.tornesol.util.tree;

import java.util.Arrays;
import java.util.List;

public class TreeDemo {

    public static void main(String[] args) {

        Tree treeDemo = new Tree(genNodeList());
        treeDemo.getRoots();
    }

    public static List<ITreeNode> genNodeList() {

        List<ITreeNode> nodeList = Arrays.asList(
                new TreeNode(1, 8, "类别", 0),
                new TreeNode(1, 69, "歌单", 8),
                new TreeNode(1, 71, "节目", 8),
                new TreeNode(1, 86, "内容", 8),
                new TreeNode(1, 87, "付费", 0),
                new TreeNode(1, 95, "方言", 0),
                new TreeNode(1, 140, "一级", 86),
                new TreeNode(1, 141, "二级", 140),
                new TreeNode(1, 142, "三级", 141),
                new TreeNode(1, 156, "甲2", 154),
                new TreeNode(1, 157, "乙", 154),
                new TreeNode(1, 158, "乙1", 157),
                new TreeNode(1, 159, "乙2", 157),
                new TreeNode(1, 160, "王牌节目", 0)
        );
        return nodeList;
    }

}
