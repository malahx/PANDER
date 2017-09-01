package fr.redpanda.pander.controllers.base;

import javax.swing.JFrame;

public interface IBaseCtrl {
	public BaseCtrl loadController(JFrame frame);
	public void initEvent();
	public void initView();
	public void setupDatas();
}
