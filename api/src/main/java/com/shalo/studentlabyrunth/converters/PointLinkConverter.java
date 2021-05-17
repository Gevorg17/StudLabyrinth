package com.shalo.studentlabyrunth.converters;

import com.shalo.studentlabyrunth.domain.Point_link;

public class PointLinkConverter extends Converter<Point_link> {
    @Override
    public Point_link convert(String[] props) {
        int way_id = Integer.parseInt(props[0]);
        int point_id = Integer.parseInt(props[1]);

        return new Point_link(way_id,point_id);
    }
}
