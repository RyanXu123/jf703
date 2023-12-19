package online.jf703.control_703;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import online.jf703.mapper.logMapper;
import online.jf703.entity.log;

import java.util.ArrayList;
import java.util.List;
@Controller
public class aicontrol_703_controller {
    String openai = "0";
    String restart = "0";

    @Autowired
    private logMapper logmapper;

    @CrossOrigin
    @RequestMapping("/jf703/aicontrol")
    @ResponseBody
    public List<String> aicontrol() {
        List ret = new ArrayList<>();
        ret.add(openai);
        ret.add(restart);

        return ret;
    }


    @CrossOrigin
    @PostMapping("/jf703/log/aicontrol")
    @ResponseBody
    public List<String> aicontrol_log(@RequestBody List<String> data) {
        String aiopenlog = "";
        String rebootlog = "";

        String openaiTemp = data.get(0);
        String restartTemp = data.get(1);
        String userName = data.get(2);
        String userRole = data.get(3);
        String time_operate = data.get(4);


        if (restartTemp.equals("1")) {
            rebootlog = "一键恢复开启";
            if (!restartTemp.equals(restart)) {
                log log1 = new log();
                log1.setDatacenter_room("JF703");
                log1.setContent(rebootlog);
                log1.setUserName(userName);
                log1.setUserRole(userRole);
                log1.setTime(time_operate);

                logmapper.insert(log1);
            }

        } else if (restart.equals("0")) {
            rebootlog = "一键恢复关闭";
            if (!restartTemp.equals(restart)) {
                log log1 = new log();
                log1.setDatacenter_room("JF703");
                log1.setContent(rebootlog);
                log1.setUserName(userName);
                log1.setUserRole(userRole);
                log1.setTime(time_operate);

                logmapper.insert(log1);
            }
        }
        restart = restartTemp;


        if (openai.equals("1")) {
            aiopenlog = "AI开启";
            if (!openaiTemp.equals(openai)) {
                log log2 = new log();
                log2.setDatacenter_room("JF703");
                log2.setContent(aiopenlog);
                log2.setUserName(userName);
                log2.setUserRole(userRole);
                log2.setTime(time_operate);

                logmapper.insert(log2);
            }
        } else if (openai.equals("0")) {
            aiopenlog = "AI关闭";
            if (!openaiTemp.equals(openai)) {
                log log2 = new log();
                log2.setDatacenter_room("JF703");
                log2.setContent(aiopenlog);
                log2.setUserName(userName);
                log2.setUserRole(userRole);
                log2.setTime(time_operate);

                logmapper.insert(log2);
            }
        }
        openai = openaiTemp;
        return data;
    }
}
