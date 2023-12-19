package online.jf703.control_703;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import online.jf703.entity.realdata_kt;
import online.jf703.service.realdata_ktService;
import online.jf703.mapper.realdata_ktMapper;
import online.jf703.entity.realdata_server;
import online.jf703.mapper.realdata_serverMapper;
import online.jf703.service.realdata_serverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class realdata_703_controller {

    @Autowired
    private realdata_ktService realdata_ktservice;
    @Autowired
    private realdata_serverService realdata_serverservice;
    @Autowired
    private realdata_ktMapper realdata_ktMapper;

    @Autowired
    private realdata_serverMapper realdata_serverMapper;

    @CrossOrigin
    @RequestMapping("/jf703/realdata_kt")
    @ResponseBody
    public List<realdata_kt> realdataKt() {
        QueryWrapper<realdata_kt> queryWrapper = new QueryWrapper<>();
        List<realdata_kt> list = realdata_ktMapper.selectList(queryWrapper);

        return list;
    }

    @CrossOrigin
    @PostMapping("/jf703/realdata_kt")
    @ResponseBody
    public List<realdata_kt> realdataKt(@RequestBody List<String> data) {
        String start_time = data.get(0);
        String end_time = data.get(1);

        QueryWrapper<realdata_kt> andWrapper = new QueryWrapper<>();
        andWrapper.between("sampleTime", start_time, end_time);
        List<realdata_kt> list = realdata_ktservice.list(andWrapper);
        return list;
    }

    @CrossOrigin
    @RequestMapping("/jf703/realdata_server")
    @ResponseBody
    public List<realdata_server> realdataServer() {
        QueryWrapper<realdata_server> queryWrapper = new QueryWrapper<>();
        List<realdata_server> list = realdata_serverMapper.selectList(queryWrapper);

        return list;
    }

    @CrossOrigin
    @PostMapping("/jf703/realdata_server")
    @ResponseBody
    public List<realdata_server> realdataServer(@RequestBody List<String> data) {
        String start_time = data.get(0);
        String end_time = data.get(1);

        QueryWrapper<realdata_server> andWrapper = new QueryWrapper<>();
        andWrapper.between("time", start_time, end_time);
        List<realdata_server> list = realdata_serverservice.list(andWrapper);
        return list;
    }
}
