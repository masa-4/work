package jp.school.portal.api.response.stundent;

import java.util.List;

import lombok.Data;

@Data
public class OutputBoundary<StudentResponse> {

    private List<StudentResponse> students;    // データリスト
    private int totalCount;  // 検索結果の件数

    public OutputBoundary(List<StudentResponse> data, int totalItems) {
        this.students = data;
        this.totalCount = totalItems;
    }
}
