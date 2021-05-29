package com.iseven.learn.xdlearn.controller;

import com.iseven.learn.xdlearn.util.ResultData;
import com.iseven.learn.xdlearn.model.dto.VideoOrderRequest;
import com.iseven.learn.xdlearn.model.po.VideoOrder;
import com.iseven.learn.xdlearn.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {


    @Autowired
    private VideoOrderService videoOrderService;


    /**
     * 下单接口
     * @return
     */
    @RequestMapping("save")
    public ResultData saveOrder(@RequestBody(required=false) VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");


        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());

        return rows == 0 ? ResultData.error("下单失败"):ResultData.success();
    }


    /**
     * 订单列表
     * @param request
     * @return
     */
    @GetMapping("list")
    public ResultData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);

        return ResultData.success(videoOrderList);

    }


}
