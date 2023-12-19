package online.jf703.control_703;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import online.jf703.mapper.jfdisplayMapper;
import online.jf703.entity.jfdisplay;
import online.jf703.service.jfdisplayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class jfdisplay_703_controller {

    @Autowired
    private jfdisplayMapper jfDisplayMapper;

    @CrossOrigin
    @RequestMapping("/jf703/aipreparams")
    @ResponseBody
//    @Scheduled(fixedRate = 30000)
    public List<jfdisplay> aipreparams703(){
        QueryWrapper<jfdisplay> queryWrapper = new QueryWrapper<>();
        queryWrapper.notIn("content", "机房IT总功率", "机房空调总功率", "机房PUE");
        List<jfdisplay> list_aipreparams = jfDisplayMapper.selectList(queryWrapper);
        return list_aipreparams;
    }

    @CrossOrigin
    @RequestMapping("/jf703/jfparams")
    @ResponseBody
    @Scheduled(fixedRate = 30000)
    public List<jfdisplay> jfparams703() {
        QueryWrapper<jfdisplay> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("content", "机房IT总功率", "机房空调总功率", "机房PUE");
        List<jfdisplay> list_jfparams = jfDisplayMapper.selectList(queryWrapper);
        return list_jfparams;
    }
}
