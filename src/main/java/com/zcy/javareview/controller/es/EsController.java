package com.zcy.javareview.controller.es;

import com.zcy.javareview.service.ElasticSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/4/6 14:52
 * @description:
 */
@RestController
@RequestMapping("/es")
@Tag(name = "es测试")
public class EsController {

    Logger logger = LogManager.getLogger(EsController.class.getName());
    //调用service层index方法
    @Autowired
    ElasticSearchService elasticSearchService;

    @RequestMapping("/index")
    @Operation(description = "初始化索引")
    public void index() {
        elasticSearchService.initIndex();
        logger.info("初始化索引成功");
    }

}
