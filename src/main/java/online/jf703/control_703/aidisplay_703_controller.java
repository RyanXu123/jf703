package online.jf703.control_703;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import online.jf703.service.jfdisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import online.jf703.mapper.aidisplayMapper;
import online.jf703.entity.aidisplay;
import online.jf703.service.aidisplayService;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


@Controller
public class aidisplay_703_controller {
    @Autowired
    private aidisplayMapper aidisplaymapper;




    @CrossOrigin
    @RequestMapping("/jf703/aidisplay")
    @ResponseBody
    public Map<String, Object>aidisplay703(){
        //构建查询条件
        QueryWrapper<aidisplay> queryWrapper = new QueryWrapper<>();
       queryWrapper.orderByDesc("time").last("LIMIT 3");

        List<aidisplay> list = aidisplaymapper.selectList(queryWrapper);

        Map<String, Object> ret = new HashMap<>();
        List<String> jf_hot = new ArrayList<>();

        // 遍历查询结果
        for (int i = 0; i < list.size(); i++) {
            aidisplay c = list.get(i);
            Object status = c.getStatus();


            if (i == 0) {
                ret.put("AI启停状态", status.toString());
            } else if (i == list.size() - 1) {
                ret.put("机房状态", jf_hot);
                ret.put("AI触发模块", status.toString());
            } else {
                jf_hot.add(status.toString());
            }
        }
        return ret;
    }

}
