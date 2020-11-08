package com.malp.issuemanagement.dtos;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Project data transfer object")
public class ProjectDto {
    @ApiModelProperty(value = "Project Id")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "Name of project", required = true)
    private String projectName;

    @NotNull
    @ApiModelProperty(value = "Code of project", required = true)
    private String projectCode;
}
