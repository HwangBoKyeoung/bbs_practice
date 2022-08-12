package egovframework.example.free.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FreeBulletinVO {

	private int freeNo;
	private String freeTitle;
	private String freeContent;
	private String freeWriter;
	private String freeDate;
	private int freeHit;
	private String freeRegYn;
	private String freeNoticeYn;

}
