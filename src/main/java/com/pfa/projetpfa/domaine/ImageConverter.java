package com.pfa.projetpfa.domaine;

import com.pfa.projetpfa.service.model.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageConverter {
    public static ImageVo toVo(Image bo){
        if (bo == null || bo.getId() == null)
            return null;
        ImageVo vo = new ImageVo();
        vo.setId(bo.getId());
        vo.setImg(bo.getImg());
        vo.setProduct(bo.getProduct());
        vo.setIs_deleted(bo.isIs_deleted());
        return vo;
    }
    public static Image toBo(ImageVo vo){
        if (vo == null || vo.getId() == null)
            return null;
        Image bo = new Image();
        bo.setId(vo.getId());
        bo.setImg(vo.getImg());
        bo.setProduct(vo.getProduct());
        bo.setIs_deleted(vo.isIs_deleted());
        return bo;
    }
    public static List<ImageVo> toListVo(List<Image> listBo){
        List<ImageVo> listVo = new ArrayList<>();
        for (Image image: listBo){
            listVo.add(toVo(image));
        }
        return listVo;
    }
}
