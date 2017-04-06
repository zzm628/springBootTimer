package com.etiantian.recommendation.timer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by zzm on 2017/3/30 13:59.
 */
@Component
public class Jobs implements SchedulingConfigurer {

    @Value("${cron}")
    private String cron = "1 * * * * ?";

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(" >>cron执行.... " + new Date());
                System.out.println("cron===" + cron);
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });
    }


    public void setCron(String cron) {
        //this.cron = cron;
    }

    /**
     * 第一位，表示秒，取值0-59
     * 第二位，表示分，取值0-59
     * 第三位，表示小时，取值0-23
     * 第四位，日期天/日，取值1-31
     * 第五位，日期月份，取值1-12
     * 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思，另外：1表示星期天，2表示星期一。
     * 第七位，年份，可以留空，取值1970-2099
     */
    //@Scheduled(cron = "0 20 1 * * ?")
    /*@Scheduled(cron = "* * * * * ?")
    public void cronJob() {
        System.out.println(" >>cron执行.... " + new Date());
        Application.applicationContext.
    }*/
}
