package com.example.scheduling.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * created by Atiye Mousavi
 * Date: 9/26/2021
 * Time: 10:05 AM
 */

@Configuration
@Slf4j
public class ScheduledJobsWithExpression {

    //در اینجا این جاب بصورت پیشفرض غیرفعال است
    //اگر می خواهیم کار را فعال کنیم ، تنها کاری که باید انجام دهیم این است که یک عبارت cron معتبر برای jobs.cronSchedule ارائه دهیم. ما می توانیم این کار را مانند سایر پیکربندی های Spring انجام دهیم: command-lin arguman ، enviroment variable ، property file و غیره.
    //
    //بر خلاف عبارات cron ، راهی برای تعیین تاخیر ثابت یا مقدار نرخ ثابت وجود ندارد که کار را غیرفعال کند. بنابراین این رویکرد فقط با مشاغل برنامه ریزی شده cron کار می کند.
    @Scheduled(cron = "${jobs.cronSchedule:-}")
    public void cleanTempDirectory(){
        log.info("Cleaning temp directory via placeholder");
    }
}
