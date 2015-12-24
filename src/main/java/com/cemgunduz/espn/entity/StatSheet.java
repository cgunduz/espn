package com.cemgunduz.espn.entity;

public class StatSheet  {

	private double min;
	private double fgm;
	private double fga;
	private double fgp;
	private double ftm;
	private double fta;
	private double ftp;
	private double p3m;
	private double reb;
	private double ast;
	private double stl;
	private double blk;
	private double to;
	private double pts;
	
	private SheetType sheetType;
	
	public SheetType getSheetType() {
		return sheetType;
	}

	public void setSheetType(SheetType sheetType) {
		this.sheetType = sheetType;
	}

	public double getTsp() {
		
		return (pts * 100) / (2 * (fga + 0.44 * fta));
	}
	
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getFgm() {
		return fgm;
	}
	public void setFgm(double fgm) {
		this.fgm = fgm;
	}
	public double getFga() {
		return fga;
	}
	public void setFga(double fga) {
		this.fga = fga;
	}
	public double getFgp() {
		return fgp;
	}
	public void setFgp(double fgp) {
		this.fgp = fgp;
	}
	public double getFtm() {
		return ftm;
	}
	public void setFtm(double ftm) {
		this.ftm = ftm;
	}
	public double getFta() {
		return fta;
	}
	public void setFta(double fta) {
		this.fta = fta;
	}
	public double getFtp() {
		return ftp;
	}
	public void setFtp(double ftp) {
		this.ftp = ftp;
	}
	public double getP3m() {
		return p3m;
	}
	public void setP3m(double p3m) {
		this.p3m = p3m;
	}
	public double getReb() {
		return reb;
	}
	public void setReb(double reb) {
		this.reb = reb;
	}
	public double getAst() {
		return ast;
	}
	public void setAst(double ast) {
		this.ast = ast;
	}
	public double getStl() {
		return stl;
	}
	public void setStl(double stl) {
		this.stl = stl;
	}
	public double getBlk() {
		return blk;
	}
	public void setBlk(double blk) {
		this.blk = blk;
	}
	public double getTo() {
		return to;
	}
	public void setTo(double to) {
		this.to = to;
	}
	public double getPts() {
		return pts;
	}
	public void setPts(double pts) {
		this.pts = pts;
	}

	@Override
	public String toString() {
		return "StatSheet{" +
				", fgm=" + fgm +
				", fga=" + fga +
				", fgp=" + fgp +
				", ftm=" + ftm +
				", fta=" + fta +
				", ftp=" + ftp +
				", p3m=" + p3m +
				", reb=" + reb +
				", ast=" + ast +
				", stl=" + stl +
				", blk=" + blk +
				", to=" + to +
				", pts=" + pts +
				'}';
	}
}
