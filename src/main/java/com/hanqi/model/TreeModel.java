package com.hanqi.model;

import java.util.List;

public class TreeModel extends Sysmenu {
    private boolean spread; // 是否展开
    private boolean disabled; // 是否禁用
    private boolean checked; // 是否选中
    private List<TreeModel> children; // 子节点数据

    public TreeModel() {
    }

    public TreeModel(Sysmenu sysmenu) {
        this.setIds(sysmenu.getIds());
        this.setParentid(sysmenu.getParentid());
        this.setIcon(sysmenu.getIcon());
        this.setLabel(sysmenu.getLabel());
        this.setUrl(sysmenu.getUrl());
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeModel{" +
                "spread=" + spread +
                ", disabled=" + disabled +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
