package online.jf703.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data

public class realdata_server {
    @TableId
    private String location;
    private String equipment;
    private String pointName;
    private String siteName;
    private String value0;
    private String time;
}
