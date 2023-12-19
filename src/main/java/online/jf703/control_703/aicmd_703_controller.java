package online.jf703.control_703;

import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import online.jf703.entity.aicmd;
import online.jf703.mapper.aicmdMapper;
import online.jf703.service.aicmdService;
import java.util.List;
import java.util.Map;

@Controller
public class aicmd_703_controller {

    @Autowired
    private aicmdMapper aicmdmapper;

    @CrossOrigin
    @RequestMapping("/jf703/aicmd_history")
    @ResponseBody

    public List<Map<String,Object>> aicmd_history703(){
        QueryWrapper<aicmd> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("CommandType", "群控控制", "保底控制", "预控控制");
        List<Map<String, Object>> list = aicmdmapper.selectMaps(queryWrapper);

        return list;
    }


    @CrossOrigin
    @PostMapping("/jf703/aicmd_selectBytime")
    @ResponseBody
    public List<Map<String, Object>> aicmd_selectBytime703(@RequestBody List<String> data) {
        String start_time = data.get(0);
        String end_time = data.get(1);

        QueryWrapper<aicmd> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("CommandType", "群控控制", "保底控制", "预控控制")
                .between("time",start_time, end_time);

        List<Map<String, Object>> list = aicmdmapper.selectMaps(queryWrapper);

        return list;
    }

    @CrossOrigin
    @PostMapping("/jf703/aicmd_selectBytype")
    @ResponseBody
    public List<Map<String,Object>> aicmd_selectBytype(@RequestBody Map<String,String> data){
        QueryWrapper<aicmd> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("CommandType", "群控控制", "保底控制", "预控控制");

        List<Map<String, Object>> list = aicmdmapper.selectMaps(queryWrapper);

        return list;

    }

    @CrossOrigin
    @PostMapping("/jf703/aicmd")
    @ResponseBody
    public List<Map<String,Object>> aicmd703(){
        QueryWrapper<aicmd> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne("CommandType", "心跳控制")
                .orderByDesc("id");
        List<Map<String, Object>> list = aicmdmapper.selectMaps(queryWrapper);

        return list;
    }
}
