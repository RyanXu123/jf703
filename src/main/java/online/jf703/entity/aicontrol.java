package online.jf703.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class aicontrol {
    @TableId
    private String location;
    private String content;
    private String detail;
    private String time;
}
