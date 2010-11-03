package com.dmr;

public class DMRDataDecode {
	private int dibit_buf[]=new int[144];
	private String line[]=new String[10];
	private boolean res;
	
	public String[] decode (DMRDecode theApp,int[] buf)	{
		String cline;
		DecodeCACH cachdecode=new DecodeCACH();
		SlotType slottype=new SlotType();
		dibit_buf=buf;
		line[0]=theApp.getTimeStamp()+" DMR Data Frame ";
		// CACH decode
		cline=cachdecode.decode(dibit_buf);
		res=cachdecode.isPassErrorCheck();
		if (res==true) line[1]=cline;
		// Slot Type Decode
		if (res==true) line[2]=slottype.decode(dibit_buf);
		theApp.frameCount++;
		return line;
	}

	public boolean isError() {
		return res;
	}
	

}
