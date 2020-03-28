/*
 * This source code is part of TWaver 1.4.1
 *
 * SERVA Software PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Copyright 2000-2005 SERVA Software, Inc. All rights reserved.
 */

package com.ffcs.alarmwatch.topoconfig;

import com.ffcs.alarmwatch.ciralarmquery4circuittopo.CirAlarmQuery4CircuitTopoTopComponent;
import com.ffcs.alarmwatch.circuittopo.CircuitPropertiesTopComponent;
import com.ffcs.alarmwatch.circuittopobyright.CircuitTopoByRightTopComponent;
import com.ffcs.alarmwatch.cirroutetopo.CirroutePropertiesTopComponent;
import com.ffcs.alarmwatch.cirroutetopo.CirrouteTopoTopComponent;
import com.ffcs.alarmwatch.custalarmquery4circuittopo.CustAlarmQuery4CircuitTopoTopComponent;
import com.ffcs.alarmwatch.protectcircuit.ProtectCircuitPropertiesTopComponent;
import com.ffcs.alarmwatch.protectcircuit.ProtectCircuitTopoTopComponent;
import com.ffcs.system.pub.Logon;
import com.ffcs.tsmclient.TemipClientHelper;
import com.ffcs.util.AppContext;
import com.ffcs.util.bo.alarmwatch.CircuitWFFacade;
import com.ffcs.util.bo.alarmwatch.CustomerWFFacade;
import com.ffcs.util.bo.alarmwatch.PortWFFacade;
import com.ffcs.util.domain.alarmwatch.Circuit;
import com.ffcs.util.domain.alarmwatch.Cirroutecon;
import com.ffcs.util.domain.alarmwatch.Customer;
import com.ffcs.util.domain.alarmwatch.Ne;
import com.ffcs.util.domain.alarmwatch.Port;
import com.ffcs.util.domain.alarmwatch.Region;
import com.ffcs.util.domain.alarmwatch.ViewCirroutePort;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import twaver.DataBoxSelectionModel;
import twaver.Element;
import twaver.EllipseGroup;
import twaver.Link;
import twaver.Node;
import twaver.PopupMenuFactory;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.network.TNetwork;
import twaver.network.action.AlignBottomAction;
import twaver.network.action.AlignCenterAction;
import twaver.network.action.AlignLeftAction;
import twaver.network.action.AlignMiddleAction;
import twaver.network.action.AlignRightAction;
import twaver.network.action.AlignTopAction;
import twaver.network.action.BaseAction;
import twaver.network.action.BottomPileAction;
import twaver.network.action.EvenHSpaceAction;
import twaver.network.action.EvenVSpaceAction;
import twaver.network.action.LeftPileAction;
import twaver.network.action.MoveFirstAction;
import twaver.network.action.MoveLastAction;
import twaver.network.action.RightPileAction;
import twaver.network.action.SameHeightAction;
import twaver.network.action.SameWidthAction;
import twaver.network.action.TopPileAction;
import twaver.network.background.ColorBackground;


/**
 * This this default popup menu factory for editable network.
 * It provides the familiar menus for editable network, like
 * align location, event space, move the layer etc.
 */
public class NetworkPopupMenuFactory implements PopupMenuFactory {
    private TDataBox box = null;
    private TNetwork network = null;
    private boolean isShow = true;
    
    /**
     * Constructs the menu factory by given network.
     * @param network the network component.
     */
    public NetworkPopupMenuFactory(TDataBox box, TNetwork network) {
        this.box = box;
        this.network = network;
    }
    
    /**
     * Get the popup menu by given network selection model.
     * @param selectionModel the selection model.
     * @return the popup menu.
     */
    public JPopupMenu getPopupMenu(final DataBoxSelectionModel selectionModel,Point p) {
        JPopupMenu popMenu = new JPopupMenu();
        JMenuItem item;
        BaseAction action;
        //if select nothing
        if (network.getDataBox().getSelectionModel().size() == 0) {
            
            /*action = new ClearDataBoxAction(network);
            item = new JMenuItem(action);
            item.setText(action.getActionName());
            popMenu.add(item);
             
            item = new JMenuItem("Save SubNetwork");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FileFilter() {
                        public boolean accept(File f) {
                            return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
                        }
                        public String getDescription() {
                            return "XML File";
                        }
                    });
                    int returnVal = chooser.showSaveDialog(network);
                    if (returnVal != JFileChooser.APPROVE_OPTION) {
                        return;
                    }
                    String fileName = chooser.getSelectedFile().getAbsolutePath();
                    try {
                        network.saveCurrentSubNetwork(fileName, false, true);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            popMenu.add(item);
             */
            
            /*���ڵõ��Ӳ˵�name
            JMenu testitem = new JMenu("TEST");
            popMenu.add(testitem);
            item = new JMenuItem("test1");
            item.setName("test1");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    //JMenuItem menuitem = (JMenuItem)e.getSource();
                    //JOptionPane.showMessageDialog("You clicked '" + element.getName() + "'");
                    System.out.println("You clicked -----" + ((JMenuItem)e.getSource()).getText());//+element.getName());
                }
            });
            testitem.add(item);*/
            
            JMenu Layoutitem = new JMenu("�Զ�����");
            popMenu.add(Layoutitem);
            item = new JMenuItem("���β���");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    network.doLayout(TWaverConst.LAYOUT_CIRCULAR);
                    /*network.doLayout(TWaverConst.LAYOUT_CIRCULAR, true, null, new Generator(){
                        public Object generate(Object element) {
                            if(element instanceof Group){
                                    Group group = (Group)element;
                                    group.setExpand(true);
                                    Rectangle bounds = network.getElementBounds(group);
                                    bounds.grow(-bounds.width/6, -bounds.height/6);
                                    group.setExpand(false);
                                    return new Dimension(bounds.width, bounds.height);
                            }
                            return null;
                        }
                    });*/
                }
            });
            
            Layoutitem.add(item);
            
            item = new JMenuItem("�ȼ�ʽ����");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    network.doLayout(TWaverConst.LAYOUT_HIERARCHIC);
                }
            });
            
            Layoutitem.add(item);
            
            item = new JMenuItem("���Ⲽ��");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    network.doLayout(TWaverConst.LAYOUT_SYMMETRIC);
                }
            });
            
            Layoutitem.add(item);
            
            item = new JMenuItem("��״����");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    network.doLayout(TWaverConst.LAYOUT_TREE);
                }
            });
            
            Layoutitem.add(item);
            
        /*}
        else {
            final Element element = network.getDataBox().getLastSelectedElement();
            final ViewCircuitPort vcp = (ViewCircuitPort)element.getClientProperty("vcp");
         
            item=new JMenuItem("��ȡ�˿���Ϣ");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(network,
                            "<html><font color=blue>" + vcp.getAp_portid() + "</font> �˿���Ϣ</html>");
                }
            });
            popMenu.add(item);
         
            popMenu.add(getLayerMenu());
            popMenu.add(getAlignMenu());
            popMenu.add(getEvenSpaceMenu());
            popMenu.add(getPileMenu());
            popMenu.add(getSameSizeMenu());
         
            item=new JMenuItem("Reset Default Size");
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Iterator it=selectionModel.getAllSelectedElement().iterator();
                    while(it.hasNext()){
                        Element element=(Element)it.next();
                        if(element instanceof ResizableNode){
                            if(element.getImage()!=null){
                                int width=element.getImage().getIconWidth();
                                int height=element.getImage().getIconHeight();
                                ( (ResizableNode) element).setSize(width,height);
                            }
                        }
                    }
                }
            });
            popMenu.add(item);
         
            popMenu.addSeparator();
            //copy menu.
            action = new CopyAction(network);
            item = new JMenuItem(action);
            item.setText(action.getActionName());
            popMenu.add(item);
        }*/
            
        /*
        action = new PasteAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        item.setEnabled(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null) != null);
        popMenu.add(item);
         */
            
        /*
        if(network.getDataBox().getSelectionModel().size() == 1){
            final Element element = network.getDataBox().getLastSelectedElement();
         
            item = new JMenuItem("Edit Label");
            popMenu.add(item);
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Element element = network.getDataBox().getLastSelectedElement();
                    network.startEditingAtElement(element);
                }
            });
         
            item = new JMenuItem("Deep Clone");
            popMenu.add(item);
            item.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Element element = network.getDataBox().getLastSelectedElement();
                    element = TWaverUtil.cloneElement(element, false);
                    network.getDataBox().addElementWithDescendant(element);
                    if(element instanceof Link){
                        Link link = (Link)element;
                        network.getDataBox().addElement((link.getFrom()));
                        network.getDataBox().addElement((link.getTo()));
                    }
                }
            });
         
            if(element instanceof Slot){
                item = new JMenuItem("Adjust Slot Bounds");
                popMenu.add(item);
                item.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        ((Slot)element).adjustBounds();
                    }
                });
            }
         
            if(element instanceof Card){
                item = new JMenuItem("Adjust Card Bounds");
                popMenu.add(item);
                item.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        ((Card)element).adjustBounds();
                    }
                });
            }
         
            if(element instanceof Shelf){
                item = new JMenuItem("Adjust Shelf Bounds");
                popMenu.add(item);
                item.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        ((Shelf)element).adjustBounds();
                    }
                });
            }
        }
         */
            
            popMenu.addSeparator();
            //item = new JMenuItem("Background Color");
            item = new JMenuItem("������ɫ");
            popMenu.add(item);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Color color = JColorChooser.showDialog(network,
                            TWaverUtil.getString("PICK_COLOR"),
                            Color.white);
                    if (color != null) {
                        network.setCurrentBackground(new ColorBackground(color));
                    }
                }
            });
            
            item = new JMenuItem("����λ��");
            //��������λ�ù��ܵ�Ȩ�޿���
            item.setEnabled(Logon.verifyRight(Logon.R_ALM_TOPO_LOCATION));
            popMenu.add(item);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //JOptionPane.showMessageDialog(network, "����λ��");
                    //Iterator itt = box.iterator();
                    try{
                        CircuitWFFacade circuitWFFacade = (CircuitWFFacade)AppContext.getInstance().getAppContext().getBean("circuitWFFacade");
                        circuitWFFacade.updateCircuitTopoLocation(box);
                        JOptionPane.showMessageDialog(network, "����λ�ñ���ɹ���", "��ȷ", JOptionPane.INFORMATION_MESSAGE);
                    }catch(Exception ex){
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(network, "����λ�ñ���ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            /*
            //������е�·������ͼ��������ʾ���ص�·���ƹ���
            Iterator itt = box.iterator();
            while (itt.hasNext()) {
                Object obj = (Object)itt.next();
                if(obj instanceof Circuit){
                    item = new JMenuItem("��ʾ/���ص�·����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            //JOptionPane.showMessageDialog(network, "��ʾ���ص�·����");
                            List circuitnamelst = new ArrayList();
                            for (Iterator it = box.iterator(); it.hasNext();) {
                                Object obj = (Object)it.next();
                                if(obj instanceof Circuit){
                                    Circuit circuit = (Circuit) obj;
                                    circuitnamelst.add(circuit);
                                }
                            }
                            if(isShow){
                                for (Iterator it = circuitnamelst.iterator(); it.hasNext();) {
                                    Circuit circuit = (Circuit)it.next();
                                    network.getDataBox().getElementByID("circuit"+circuit.getCircuitid()).setName(null);
                                }
                                isShow = false;
                            }
                            if(!isShow){
                                for (Iterator it = circuitnamelst.iterator(); it.hasNext();) {
                                    Circuit circuit = (Circuit)it.next();
                                    network.getDataBox().getElementByID("circuit"+circuit.getCircuitid()).setName(circuit.getNamecn());
                                }
                                isShow = true;
                            }
                        }
                    });
                    break;
                }
             
            }*/
        }if (network.getDataBox().getSelectionModel().size() == 1) {
            List list = network.getDataBox().getSelectionModel().getAllSelectedElement();
            for (Iterator it = list.iterator(); it.hasNext();) {
                
                Element element = (Element) it.next();
                if(element instanceof Circuit){
                    final Circuit circuit = (Circuit) element;
                    //����ǵ�·,�鿴�澯��·�б�
                    item = new JMenuItem("�鿴�����澯��·");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
//                            EllipseGroup fromellipseGroup = (EllipseGroup)circuit.getFrom().getParent();
//                            EllipseGroup toellipseGroup = (EllipseGroup)circuit.getTo().getParent();
                            Node fromellipseGroup = (Node)circuit.getFrom().getParent();
                            Node toellipseGroup = (Node)circuit.getTo().getParent();
                            if(fromellipseGroup != null && toellipseGroup != null && fromellipseGroup != toellipseGroup){
                                List linkList = TWaverUtil.getBundledLinks(fromellipseGroup, toellipseGroup);
                                if(linkList==null){
                                    JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(), "������޸澯��·��");
                                    return;
                                }
                                String circuitids="";
                                //List childList = element.getChildren();
                                for (Iterator it = linkList.iterator(); it.hasNext();) {
                                    Circuit ccircuit = (Circuit)it.next();
                                    circuitids = circuitids + ccircuit.getCircuitid() + ",";
                                }
                                if(circuitids.length()>0) circuitids = circuitids.substring(0,circuitids.length()-1);
                                //����Ѿ��򿪸澯��·�б��ڣ��Ͳ����ظ���
                                Set topComponents = TopComponent.getRegistry().getOpened();
                                Vector cirAlarmQueryDisplays = new Vector();
                                Iterator iterator = topComponents.iterator();
                                while (iterator.hasNext()) {
                                    Object theObject = iterator.next();
                                    if (theObject instanceof CirAlarmQuery4CircuitTopoTopComponent) {
                                        cirAlarmQueryDisplays.add(theObject);
                                    }
                                }
                                iterator = cirAlarmQueryDisplays.iterator();
                                int i = 0;
                                while (iterator.hasNext()) {
                                    CirAlarmQuery4CircuitTopoTopComponent cirAlarmQueryDisplay = (CirAlarmQuery4CircuitTopoTopComponent) iterator.next();
                                    String winname = fromellipseGroup.getDisplayName() +"��" + toellipseGroup.getDisplayName() + "-�澯��·�б�";
                                    if(winname.equals(cirAlarmQueryDisplay.getName())){//cust4circuit.getCustomerid().equals(circuitTopoByRightDisplay.getDefault().getCustomerid())){
                                        i++;
                                        cirAlarmQueryDisplay.requestActive();
                                        break;
                                    }
                                }
                                if(i==0) {
                                    CirAlarmQuery4CircuitTopoTopComponent cirAlarmQuery4CircuitTopo = new CirAlarmQuery4CircuitTopoTopComponent();
                                    cirAlarmQuery4CircuitTopo.CirAlarmQuery4CircuitTopoTopComponent(fromellipseGroup,toellipseGroup, circuitids);
                                    cirAlarmQuery4CircuitTopo.open();
                                    cirAlarmQuery4CircuitTopo.requestActive();
                                }
                            }else{
                                    JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(), "��������������޷���ȡ��");
                            }
                        }
                    });
                    
                    item = new JMenuItem("��·����ͬ��");
                    popMenu.add(item);
                    //��·����ͬ��
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            Runnable myOperation = new Runnable() {
                                public void run() {
                                    ProgressHandle handle = ProgressHandleFactory.createHandle(circuit.getNamecn()+"-��·����ͬ����...");
                                    handle.start();                    //handle must start first.
                                    handle.switchToIndeterminate();
                                    try {
                                        CustomerWFFacade customerWFFacade = (CustomerWFFacade)AppContext.getInstance().getAppContext().getBean("customerWFFacade");
                                        System.out.println("circuitid-------------"+circuit.getCircuitid() + "property----------" + circuit.getProperty());
                                        String retStr = customerWFFacade.synDataByCircuitID(circuit.getCircuitid(), circuit.getProperty());
                                        JOptionPane.showMessageDialog(network, retStr);
                                        /*System.out.println("��·����ͬ�������ַ���-------------"+retStr);
                                        if(retStr.equals("��Դ���ݲ�����")) {
                                            int confirm=JOptionPane.showConfirmDialog(WindowManager.getDefault().getMainWindow(), "��Դ���иõ�·����\""+circuit.getNamecn()+"\"�Ѿ������ڣ��Ƿ񽫴�ͻ��иõ�·����ɾ����", "��ʾ", JOptionPane.YES_NO_OPTION);
                                            if(confirm!=JOptionPane.YES_OPTION){
                                                handle.finish();
                                                return;
                                            }
                                            //����ɾ����ͻ��ĵ�·���ݵĴ洢����
                                            String delCircuitRetStr = customerWFFacade.delDataByCircuitID(circuit.getCircuitid(), circuit.getProperty());
                                            JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(), delCircuitRetStr);
                                        }
                                        else JOptionPane.showMessageDialog(WindowManager.getDefault().getMainWindow(), retStr);*/
                                    } catch (Exception ex) {
                                        
                                    }
                                    handle.finish();
                                }
                            };
                            (new Thread(myOperation)).start();
                        }
                    });
                }
                    
                //��·�澯����temip
                if(element instanceof Circuit && element.getAlarmState().getAlarmCount()>0){
                    final Circuit circuit = (Circuit) element;
                    item = new JMenuItem("��ʾ�澯����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Runnable myOperation = new Runnable() {
                                public void run() {
                                    PortWFFacade portWFFacade = (PortWFFacade)AppContext.getInstance().getAppContext().getBean("portWFFacade");
//                                    List port4cirrouteList = portWFFacade.getPortList(circuit.getCircuitid());
                                    //��TSM��ȡ�澯״̬
                                    int i=0;
//                                    for (Iterator it = port4cirrouteList.iterator(); it.hasNext();) {
//                                        Port port = (Port) it.next();
//                                        if(port.getEntityname()!=null&&!"".equals(port.getEntityname())) i++;
//                                    }
                                    Map map = new HashMap();
                                    map.put("circuitid",String.valueOf(circuit.getCircuitid()));
                                    map.put("property",String.valueOf(circuit.getProperty()));
                                    List port4cirrouteconList = portWFFacade.getPortList4Cirroutcon(map);
                                    for (Iterator it = port4cirrouteconList.iterator(); it.hasNext();) {
                                        Port port = (Port) it.next();
                                        if(!(port.getEntityname()==null||port.getEntityname().equals(""))) i++;
                                    }
                                    
//                                    String managedObject = circuit.getEntityname();//circuit.getEntityname();
//                                    //String managedObject = "GENTRANSNE .BIR01 TTP MS_1-2-1-1_1 CTP TU12-3-5-3$";
//                                    try {
//                                        TemipClientHelper.ShowAlarmsInTemipClient(managedObject);
//                                    } catch (Exception ex) {
//                                        ex.printStackTrace();
//                                    }
                                    
                                    String[] managedObjects = new String[i+1];
                                    managedObjects[0] = circuit.getEntityname();
                                    int j=1;
//                                    for (Iterator it = port4cirrouteList.iterator(); it.hasNext();) {
//                                        Port port = (Port) it.next();
//                                        managedObjects[j] = port.getEntityname();
//                                        j++;
//                                    }
                                    for (Iterator it = port4cirrouteconList.iterator(); it.hasNext();) {
                                        Port port = (Port) it.next();
                                        if(!(port.getEntityname()==null||port.getEntityname().equals(""))) {
                                            managedObjects[j] = port.getEntityname();
                                            j++;
                                        }
                                    }
                                    try {
                                        String filtername = "";
                                        if(circuit.getNamecn()==null||circuit.getNamecn().equals("")) filtername = "ҵ�������ͼ-"+circuit.getLogicno();
                                        else filtername = "ҵ�������ͼ-"+circuit.getNamecn();
                                        TemipClientHelper.ShowAlarmsInTemipClient(filtername, managedObjects);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            new Thread(myOperation).start();
                        }
                        
                    });
                }
                //·�ɸ澯����temip
                if(element instanceof ViewCirroutePort && element.getAlarmState().getAlarmCount()>0){
                    final ViewCirroutePort vcp = (ViewCirroutePort) element;
                    item = new JMenuItem("��ʾ�澯����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Runnable myOperation = new Runnable() {
                                public void run() {
                                    String[] managedObjects = new String[1];
                                    managedObjects[0] = vcp.getEntityname();//circuit.getEntityname();
                                    //String managedObject = "GENTRANSNE .BIR01 TTP MS_1-2-1-1_1 CTP TU12-3-5-3$";
                                    try {
                                        TemipClientHelper.ShowAlarmsInTemipClient("ҵ�������ͼ-"+vcp.getRoutename(), managedObjects);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            };
                            new Thread(myOperation).start();
                        }
                        
                    });
                }
                //�˿ڸ澯����temip
                if(element instanceof Port && element.getAlarmState().getAlarmCount()>0){
                    final Port port = (Port) element;
                    item = new JMenuItem("��ʾ�澯����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Runnable myOperation = new Runnable() {
                                public void run() {
                                    String[] managedObjects = new String[1];
                                    managedObjects[0] = port.getEntityname();//circuit.getEntityname();
                                    //String managedObject = "GENTRANSNE .BIR01 TTP MS_1-2-1-1_1 CTP TU12-3-5-3$";
                                    try {
                                        TemipClientHelper.ShowAlarmsInTemipClient("ҵ�������ͼ-"+port.getNamecn(), managedObjects);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            };
                            new Thread(myOperation).start();
                        }
                        
                    });
                }
                //·����չ�澯����temip
                if(element instanceof Cirroutecon && element.getAlarmState().getAlarmCount()>0){
                    final Cirroutecon cirroutecon = (Cirroutecon) element;
                    item = new JMenuItem("��ʾ�澯����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Runnable myOperation = new Runnable() {
                                public void run() {
                                    String[] managedObjects = new String[1];
                                    managedObjects[0] = cirroutecon.getEntityname();//circuit.getEntityname();
                                    //String managedObject = "GENTRANSNE .BIR01 TTP MS_1-2-1-1_1 CTP TU12-3-5-3$";
                                    try {
                                        TemipClientHelper.ShowAlarmsInTemipClient("ҵ�������ͼ-"+cirroutecon.getSectionname(), managedObjects);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            };
                            new Thread(myOperation).start();
                        }
                        
                    });
                }
                //��Ԫ�澯����temip
                if(element instanceof Ne && element.getAlarmState().getAlarmCount()>0){
                    final Ne ne = (Ne) element;
                    item = new JMenuItem("��ʾ�澯����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Runnable myOperation = new Runnable() {
                                public void run() {
//                                    String managedObject = ne.getEntityname();//circuit.getEntityname();
//                                    //String managedObject = "GENTRANSNE .BIR01 TTP MS_1-2-1-1_1 CTP TU12-3-5-3$";
//                                    try {
//                                        TemipClientHelper.ShowAlarmsInTemipClient(managedObject);
//                                    } catch (Exception ex) {
//                                        ex.printStackTrace();
//                                    }
                                    if((ne.getPorta_entityname()!=null&&!"".equals(ne.getPorta_entityname()))&&(ne.getPortz_entityname()!=null&&!"".equals(ne.getPortz_entityname()))){
                                        String[] managedObjects = new String[2];
                                        managedObjects[0] = ne.getPorta_entityname();
                                        managedObjects[1] = ne.getPortz_entityname();
                                        try {
                                            TemipClientHelper.ShowAlarmsInTemipClient("ҵ�������ͼ-"+ne.getNamecn(), managedObjects);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }else if((ne.getPorta_entityname()!=null&&!"".equals(ne.getPorta_entityname()))&&(ne.getPortz_entityname()==null||"".equals(ne.getPortz_entityname()))){
                                        String[] managedObjects = new String[1];
                                        managedObjects[0] = ne.getPorta_entityname();
                                        try {
                                            TemipClientHelper.ShowAlarmsInTemipClient("ҵ�������ͼ-"+ne.getNamecn(), managedObjects);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }else if((ne.getPorta_entityname()==null||"".equals(ne.getPorta_entityname()))&&(ne.getPortz_entityname()!=null&&!"".equals(ne.getPortz_entityname()))){
                                        String[] managedObjects = new String[1];
                                        managedObjects[0] = ne.getPortz_entityname();
                                        try {
                                            TemipClientHelper.ShowAlarmsInTemipClient("ҵ�������ͼ-"+ne.getNamecn(), managedObjects);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            };
                            new Thread(myOperation).start();
                        }
                        
                    });
                }
                //����ͼ���Ҽ��˵����鿴�澯�ͻ����鿴�澯��·
                //�����Ҽ��˵����鿴����澯��·
                if(element instanceof EllipseGroup){
                    final EllipseGroup ellipseGroup = (EllipseGroup) element;
                    item = new JMenuItem("�����·����");
                    popMenu.add(item);
                    //�����·����
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            /*JOptionPane.showMessageDialog(network, ellipseGroup.getDisplayName());
                            String temp_id = ellipseGroup.getID().toString();
                            JOptionPane.showMessageDialog(network, temp_id.substring(6,temp_id.length()));
                            
                            TopComponent topComponent = TopComponent.getRegistry().getActivated();
                            if(topComponent instanceof CircuitTopoByRightTopComponent) {
                                CircuitTopoByRightTopComponent circuitTopoByRightTopComponent = (CircuitTopoByRightTopComponent) topComponent;
                                JOptionPane.showMessageDialog(network, circuitTopoByRightTopComponent.getCBox().getCustomeridLb().getText());
                            }*/
                            TopComponent topComponent = TopComponent.getRegistry().getActivated();
                            String customerids="";
                            if(topComponent instanceof CircuitTopoByRightTopComponent) {
                                CircuitTopoByRightTopComponent circuitTopoByRightTopComponent = (CircuitTopoByRightTopComponent) topComponent;
                                customerids=circuitTopoByRightTopComponent.getCBox().getCustomeridLb().getText();
                            }
                            String temp_id = ellipseGroup.getID().toString();
                            String regionid = temp_id.substring(6,temp_id.length());
                            Region region = new Region();
                            region.setNamecn(ellipseGroup.getDisplayName());
                            region.setRegionid(Integer.parseInt(regionid));
                            //����Ѿ���ѡ�еĴ�ͻ��ĵ�·����ͼ���Ͳ����ظ���
                            Set topComponents = TopComponent.getRegistry().getOpened();
                            Vector circuitTopoByRightDisplays = new Vector();
                            Iterator iterator = topComponents.iterator();
                            while (iterator.hasNext()) {
                                Object theObject = iterator.next();
                                if (theObject instanceof CircuitTopoByRightTopComponent) {
                                    circuitTopoByRightDisplays.add(theObject);
                                }
                            }
                            iterator = circuitTopoByRightDisplays.iterator();
                            int i = 0;
                            while (iterator.hasNext()) {
                                CircuitTopoByRightTopComponent circuitTopoByRightDisplay = (CircuitTopoByRightTopComponent) iterator.next();
                                String winname = ellipseGroup.getDisplayName() + "-�����·����";
                                if(winname.equals(circuitTopoByRightDisplay.getName())){
                                    i++;
                                    circuitTopoByRightDisplay.requestActive();
                                    break;
                                }
                            }
                            if(i==0) {
                                CircuitTopoByRightTopComponent circuitTopoByRight = new CircuitTopoByRightTopComponent();
                                circuitTopoByRight.CircuitTopoByRightTopComponent4Region(region, customerids);
                                circuitTopoByRight.open();
                                circuitTopoByRight.requestActive();
                            }
                        }
                    });
                    item = new JMenuItem("�鿴������澯�ͻ�");
                    popMenu.add(item);
                    //��·����ͬ��
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            List childList = ellipseGroup.getChildren();
                            String customerids="";
                            //List childList = element.getChildren();
                            for (Iterator it = childList.iterator(); it.hasNext();) {
                                Element childe = (Element)it.next();
                                if(childe instanceof Customer){
                                    Customer childCust = (Customer) childe;
                                    customerids = customerids + childCust.getCustomerid() + ",";
                                }
                            }
                            if(customerids.length()>0) customerids = customerids.substring(0,customerids.length()-1);
                            //����Ѿ��򿪸澯��·�б��ڣ��Ͳ����ظ���
                            Set topComponents = TopComponent.getRegistry().getOpened();
                            Vector cirAlarmQueryDisplays = new Vector();
                            Iterator iterator = topComponents.iterator();
                            while (iterator.hasNext()) {
                                Object theObject = iterator.next();
                                if (theObject instanceof CustAlarmQuery4CircuitTopoTopComponent) {
                                    cirAlarmQueryDisplays.add(theObject);
                                }
                            }
                            iterator = cirAlarmQueryDisplays.iterator();
                            int i = 0;
                            while (iterator.hasNext()) {
                                CustAlarmQuery4CircuitTopoTopComponent custAlarmQueryDisplay = (CustAlarmQuery4CircuitTopoTopComponent) iterator.next();
                                String winname = ellipseGroup.getDisplayName() + "-�澯�ͻ��б�";
                                if(winname.equals(custAlarmQueryDisplay.getName())){//cust4circuit.getCustomerid().equals(circuitTopoByRightDisplay.getDefault().getCustomerid())){
                                    i++;
                                    custAlarmQueryDisplay.requestActive();
                                    break;
                                }
                            }
                            if(i==0) {
                                CustAlarmQuery4CircuitTopoTopComponent custAlarmQuery4CircuitTopo = new CustAlarmQuery4CircuitTopoTopComponent();
                                custAlarmQuery4CircuitTopo.CustAlarmQuery4CircuitTopoTopComponent(ellipseGroup, customerids);
                                custAlarmQuery4CircuitTopo.open();
                                custAlarmQuery4CircuitTopo.requestActive();
                            }
                        }
                    });
                    
                    item = new JMenuItem("�鿴�澯��·");
                    popMenu.add(item);
                    //�鿴�澯��·
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            List childList = ellipseGroup.getChildren();
                            String customerids="";
                            //List childList = element.getChildren();
                            for (Iterator it = childList.iterator(); it.hasNext();) {
                                Element childe = (Element)it.next();
                                if(childe instanceof Customer){
                                    Customer childCust = (Customer) childe;
                                    customerids = customerids + childCust.getCustomerid() + ",";
                                }
                            }
                            if(customerids.length()>0) customerids = customerids.substring(0,customerids.length()-1);
                            //����Ѿ��򿪸澯��·�б��ڣ��Ͳ����ظ���
                            Set topComponents = TopComponent.getRegistry().getOpened();
                            Vector cirAlarmQueryDisplays = new Vector();
                            Iterator iterator = topComponents.iterator();
                            while (iterator.hasNext()) {
                                Object theObject = iterator.next();
                                if (theObject instanceof CirAlarmQuery4CircuitTopoTopComponent) {
                                    cirAlarmQueryDisplays.add(theObject);
                                }
                            }
                            iterator = cirAlarmQueryDisplays.iterator();
                            int i = 0;
                            while (iterator.hasNext()) {
                                CirAlarmQuery4CircuitTopoTopComponent cirAlarmQueryDisplay = (CirAlarmQuery4CircuitTopoTopComponent) iterator.next();
                                String winname = ellipseGroup.getDisplayName() + "-�澯��·�б�";
                                if(winname.equals(cirAlarmQueryDisplay.getName())){//cust4circuit.getCustomerid().equals(circuitTopoByRightDisplay.getDefault().getCustomerid())){
                                    i++;
                                    cirAlarmQueryDisplay.requestActive();
                                    break;
                                }
                            }
                            if(i==0) {
                                CirAlarmQuery4CircuitTopoTopComponent cirAlarmQuery4CircuitTopo = new CirAlarmQuery4CircuitTopoTopComponent();
                                cirAlarmQuery4CircuitTopo.CirAlarmQuery4CircuitTopoTopComponent(ellipseGroup, customerids);
                                cirAlarmQuery4CircuitTopo.open();
                                cirAlarmQuery4CircuitTopo.requestActive();
                            }
                        }
                    });
                }
                //��ʾȫ��·������ ----------------------------------------------add by wangsh 20070702 begin
                if(element instanceof Circuit){
                    final Element inElement = element;
                    item = new JMenuItem("��ʾ·������ͼ");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            Circuit circuit = (Circuit)inElement;
                            if(circuit!=null){
                                /*CirrouteTopoTopComponent cirrouteTopo = new CirrouteTopoTopComponent();
                                cirrouteTopo.CirrouteTopoTopComponent(circuit);
                                cirrouteTopo.open();
                                cirrouteTopo.requestActive();*/
                                //����Ѿ���ѡ�еĵ�·��·������ͼ���Ͳ����ظ���
                                Set topComponents = TopComponent.getRegistry().getOpened();
                                Vector cirrouteTopoByRightDisplays = new Vector();
                                Iterator iterator = topComponents.iterator();
                                while (iterator.hasNext()) {
                                    Object theObject = iterator.next();
                                    if (theObject instanceof CirrouteTopoTopComponent) {
                                        cirrouteTopoByRightDisplays.add(theObject);
                                    }
                                }
                                iterator = cirrouteTopoByRightDisplays.iterator();
                                int i = 0;
                                while (iterator.hasNext()) {
                                    CirrouteTopoTopComponent cirrouteTopoByRightDisplay = (CirrouteTopoTopComponent) iterator.next();
                                    String winname = "";
                                    if(circuit.getNamecn()==null) winname = circuit.getLogicno() + "-·������";
                                    else winname = circuit.getNamecn() + "-·������";
                                    if(winname.equals(cirrouteTopoByRightDisplay.getName())){//cust4circuit.getCustomerid().equals(circuitTopoByRightDisplay.getDefault().getCustomerid())){
                                        i++;
                                        cirrouteTopoByRightDisplay.requestActive();
                                        break;
                                    }
                                }
                                if(i==0) {
                                    CirrouteTopoTopComponent cirrouteTopo = new CirrouteTopoTopComponent();
                                    //CirrouteTopoTopComponent.lookupid = 0;
                                    cirrouteTopo.CirrouteTopoTopComponent(circuit);
                                    cirrouteTopo.open();
                                    cirrouteTopo.requestActive();
                                }
                            }
                        }
                    });
                }
                if(element instanceof ViewCirroutePort){
                    item = new JMenuItem("��ʾ·����չ����ͼ");
                    popMenu.add(item);
                    final Element inElement = element;
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            ViewCirroutePort vcp = (ViewCirroutePort)inElement;
                            if(vcp!=null){
                                if(vcp.getRoutetype()==1||vcp.getRoutetype()==5){
            //                        ProtectCircuitTopoTopComponent protectCircuitTopo = new ProtectCircuitTopoTopComponent();
            //                        protectCircuitTopo.ProtectCircuitTopoTopComponent(vcp);
            //                        protectCircuitTopo.open();
            //                        protectCircuitTopo.requestActive();
                                    //����Ѿ���ѡ�е�·�ɵ�·����չ����ͼ���Ͳ����ظ���
                                    Set topComponents = TopComponent.getRegistry().getOpened();
                                    Vector protectCircuitTopoByRightDisplays = new Vector();
                                    Iterator iterator = topComponents.iterator();
                                    while (iterator.hasNext()) {
                                        Object theObject = iterator.next();
                                        if (theObject instanceof ProtectCircuitTopoTopComponent) {
                                            protectCircuitTopoByRightDisplays.add(theObject);
                                        }
                                    }
                                    iterator = protectCircuitTopoByRightDisplays.iterator();
                                    int i = 0;
                                    while (iterator.hasNext()) {
                                        ProtectCircuitTopoTopComponent protectCircuitTopoByRightDisplay = (ProtectCircuitTopoTopComponent) iterator.next();
                                        String winname = vcp.getRoutename() + "-·����չ����";
                                        if(winname.equals(protectCircuitTopoByRightDisplay.getName())){//cust4circuit.getCustomerid().equals(circuitTopoByRightDisplay.getDefault().getCustomerid())){
                                            i++;
                                            protectCircuitTopoByRightDisplay.requestActive();
                                            break;
                                        }
                                    }
                                    //------------------------------------------------------
                                    if(i==0) {
                                        ProtectCircuitTopoTopComponent protectCircuitTopo = new ProtectCircuitTopoTopComponent();
                                        //ProtectCircuitTopoTopComponent.lookupid = 0;
                                        protectCircuitTopo.ProtectCircuitTopoTopComponent(vcp);
                                        protectCircuitTopo.open();
                                        protectCircuitTopo.requestActive();
                                    }
                                    //------------------------------------------------------
                                } else {
                                    JOptionPane.showMessageDialog(network, "���ǲ�·(T)���ͻ���HDSL(I)���͵�·��,û�б���·������ͼ!");
                                }
                            }
                        }
                    });
                }
                //��ʾ����ҳ-------------------------add by wangsh 20070702 begin
                if(element instanceof Circuit){
                    item = new JMenuItem("��ʾ��·����");
                    popMenu.add(item);
                    //����¼�
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent circuitpropwin = CircuitPropertiesTopComponent.findInstance();
                            if(!circuitpropwin.isOpened()) circuitpropwin.open();//��������ͼ�ڵ�ʱ,�������ҳδ�򿪾ʹ���������ҳ����
                            circuitpropwin.requestVisible();
                        }
                    });
                }else if(element instanceof ViewCirroutePort){
                    item = new JMenuItem("��ʾ·������");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent cirroutepropwin = CirroutePropertiesTopComponent.findInstance();
                            if(!cirroutepropwin.isOpened()) cirroutepropwin.open();//������ҳδ��,�ȴ���������ҳ����
                            cirroutepropwin.requestVisible();
                        }
                    });
                }else if(element instanceof Port){
                    item = new JMenuItem("��ʾ�˿�����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent cirroutepropwin = CirroutePropertiesTopComponent.findInstance();
                            if(!cirroutepropwin.isOpened()) cirroutepropwin.open();//������ҳδ��,�ȴ���������ҳ����
                            cirroutepropwin.requestVisible();
                        }
                    });
                }else if(element instanceof Cirroutecon){
                    item = new JMenuItem("��ʾ·����չ����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent procircuitpropwin = ProtectCircuitPropertiesTopComponent.findInstance();
                            if(!procircuitpropwin.isOpened()) procircuitpropwin.open();
                            procircuitpropwin.requestVisible();
                        }
                    });
                }else if(element instanceof Ne){
                    item = new JMenuItem("��ʾ��Ԫ�豸����");
                    popMenu.add(item);
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent procircuitpropwin = ProtectCircuitPropertiesTopComponent.findInstance();
                            if(!procircuitpropwin.isOpened()) procircuitpropwin.open();
                            procircuitpropwin.requestVisible();
                        }
                    });
                }else if(element instanceof EllipseGroup){
                    item = new JMenuItem("��ʾ������ҳ��");     // -- û���ж�ѡ�е�ʵ�壬��·������ҳ
                    popMenu.add(item);
                    List childList = ((EllipseGroup) element).getChildren();
                    TopComponent topComponent = TopComponent.getRegistry().getActivated();
                    if(topComponent instanceof CircuitTopoByRightTopComponent) {
                        item.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                TopComponent circuitpropwin = CircuitPropertiesTopComponent.findInstance();
                                if(!circuitpropwin.isOpened()) circuitpropwin.open();
                                circuitpropwin.requestVisible();
                        }
                        });
                    }else if (topComponent instanceof CirrouteTopoTopComponent){
                        //����¼�
                        item.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                TopComponent cirroutepropwin = CirroutePropertiesTopComponent.findInstance();
                                if(!cirroutepropwin.isOpened()) cirroutepropwin.open();//������ҳδ��,�ȴ���������ҳ����
                                cirroutepropwin.requestVisible();
                            }
                        });
                    }
                }else if(element instanceof Link){
                    item = new JMenuItem("��ʾ��������ҳ��");     // -- û���ж�ѡ�е�ʵ�壬��·������ҳ
                    popMenu.add(item);
                    //����¼�
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent cirroutepropwin = CirroutePropertiesTopComponent.findInstance();
                            if(!cirroutepropwin.isOpened()) cirroutepropwin.open();//������ҳδ��,�ȴ���������ҳ����
                            cirroutepropwin.requestVisible();
                        }
                    });
                }else if(element instanceof Node){  //����޷��ж����ͣ���ʾ��·����ҳ
                    item = new JMenuItem("��ʾ�ڵ�����");
                    popMenu.add(item);
                    //����¼�
                    item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e) {
                            TopComponent circuitpropwin = CircuitPropertiesTopComponent.findInstance();
                            if(!circuitpropwin.isOpened()) circuitpropwin.open();
                            circuitpropwin.requestVisible();
                        }
                    });
                }
                //----------------------------------2007-07-02-add by wangsh end
            }
        }
        return popMenu;
    }
    
    /**
     * Get the align menus.
     * @return the align menus.
     */
    private JMenu getAlignMenu() {
        JMenu menu = new JMenu("Align");
        //align left menu
        BaseAction action = new AlignLeftAction(network);
        JMenuItem item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        //align vertical center menu
        action = new AlignCenterAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        //align right menu
        action = new AlignRightAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        menu.addSeparator();
        
        //align top menu
        action = new AlignTopAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        //align middle menu
        action = new AlignMiddleAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        //align bottom menu
        action = new AlignBottomAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        return menu;
    }
    
    /**
     * Get the even space menu.
     * @return the even space menu.
     */
    private JMenu getEvenSpaceMenu() {
        JMenu menu = new JMenu("Even Space");
        //add even horizontal space action.
        BaseAction action = new EvenHSpaceAction(network);
        JMenuItem item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        //add even horizontal space action.
        action = new EvenVSpaceAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        return menu;
    }
    
    private JMenu getPileMenu() {
        JMenu menu = new JMenu("Pile up");
        BaseAction action=new LeftPileAction(network);
        JMenuItem item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        action=new RightPileAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        action=new TopPileAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        action=new BottomPileAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        return menu;
    }
    
    
    /**
     * Get the same size menus.
     * @return the same size menus.
     */
    private JMenu getSameSizeMenu() {
        JMenu menu = new JMenu("Same Size");
        BaseAction action = new SameWidthAction(network);
        JMenuItem item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        action = new SameHeightAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        return menu;
    }
    
    /**
     * Get the change layer menus.
     * @return the change layer menus.
     */
    private JMenu getLayerMenu() {
        JMenu menu = new JMenu("Layer");
        //add movefirst action.
        BaseAction action = new MoveFirstAction(network);
        JMenuItem item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        //add movelast action.
        action = new MoveLastAction(network);
        item = new JMenuItem(action);
        item.setText(action.getActionName());
        menu.add(item);
        
        return menu;
    }
}