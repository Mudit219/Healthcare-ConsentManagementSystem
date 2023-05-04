package com.springboot.ConsentManagement.Entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class DoctorRecordTemplate {
    List<String> hospitalNames;
    List<ConsentedRecords> recordsList;
}
