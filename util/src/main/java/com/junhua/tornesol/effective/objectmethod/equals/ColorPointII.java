package com.junhua.tornesol.effective.objectmethod.equals;


/**
 *
 * 通过继承的方式，很难遵循equals的限定条件；通过composite的方式可以实现
 * favor composite over inheritance
 */
public class ColorPointII {

    private Point point;
    private Color color;

    public ColorPointII(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof ColorPointII)) return false;

        ColorPointII cp = (ColorPointII) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
