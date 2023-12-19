package online.jf703.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class log {
    @TableId
    private String content;
    private String datacenter_room;
    private String userName;
    private String userRole;
    private String time;
}
