package online.jf703.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class aicmd {
    @TableId
    private String location;
    private String commandType;
    private String equipment;
    private String commandContent;
    private String changedValue;

    private String time;
    private String id;
}
