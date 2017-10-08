package com.github.quantrresearch.sharepoint.online;

import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;

public class SharePointTreeNode extends DefaultMutableTreeNode {

	String type;
	String text;
	String icon;
	public boolean visible;
	static HashMap<String, Icon> iconRoot;

	static {
		iconRoot = new HashMap<>();
		//ImageIcon i = new ImageIcon(SharePointTreeNode.class.getClassLoader().getResource("/com/github/quantrresearch/sharepoint/online/icon"));
		//iconRoot= new ImageIcon(getClass().getClassLoader().getResource("/com/github/quantrresearch/sharepoint/online/icon"));
		//			System.out.println("in1=" + SharePointTreeNode.class.getClassLoader().getResourceAsStream("icon"));
		//			System.out.println("in2=" + SharePointTreeNode.class.getClassLoader().getResourceAsStream("com/github/quantrresearch/sharepoint/online/icon"));
		//			System.out.println("in3=" + SharePointTreeNode.class.getClassLoader().getResourceAsStream("/com/github/quantrresearch/sharepoint/online/icon"));
		//			InputStream in = SharePointTreeNode.class.getClassLoader().getResourceAsStream("/com/github/quantrresearch/sharepoint/online/icon");
		//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//			String resource;
		//			while ((resource = br.readLine()) != null) {
		//				System.out.println(resource);
		//			}

		Reflections reflections = new Reflections("com.github.quantrresearch.sharepoint.online.icon", new ResourcesScanner());
		Set<String> fileNames = reflections.getResources(Pattern.compile(".*\\.png"));
		for (String filepath : fileNames) {
			String filename = new File(filepath).getName();
			System.out.println("filename=" + filename + " > " + SharePointTreeNode.class.getClassLoader().getResource("/com/github/quantrresearch/sharepoint/online/icon/" + filename));
			iconRoot.put(filename, new ImageIcon(SharePointTreeNode.class.getClassLoader().getResource("/com/github/quantrresearch/sharepoint/online/icon/" + filename)));
		}
	}

	public SharePointTreeNode(String text, String type) {
		this(text, type, null);
	}

	public SharePointTreeNode(String text, String type, String icon) {
		super();
		this.text = text;
		this.type = type;
		this.icon = icon;
		if (this.icon != null && !this.icon.endsWith(".png")) {
			this.icon += ".png";
		}
		visible = true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Icon getIcon() {
		Icon temp = iconRoot.get(icon);
		System.out.println(icon + " = " + temp);
		return temp;
	}

	public String toString() {
		return text;
	}

}
