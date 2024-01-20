package com.nur.command.commend.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CommendDTO;

public class GetCommendQuery implements Command<CommendDTO> {
    String commendId;

    public GetCommendQuery(String commendId) {
        this.commendId = commendId;
    }
}
