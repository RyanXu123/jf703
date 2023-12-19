package online.jf703.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.jf703.entity.log;
import online.jf703.mapper.logMapper;
import online.jf703.service.logService;
import org.springframework.stereotype.Service;

@Service
public class logServiceImpl extends ServiceImpl<logMapper, log> implements logService {
}
