package ke.novia.controller.pos.sale;

import app.main.MainWindow;
import static app.main.NoviaMain.context;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ke.novia.model.pos.sale.OrderDestination;
import ke.novia.model.pos.sale.OrderStatus;
import ke.novia.service.pos.sale.IOrderDestinationService;
import ke.novia.service.pos.sale.IOrderMasterService;
import ke.novia.service.pos.sale.IOrderStatusService;
//import ke.novia.view.pos.sale.OrderMaster;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class OrderMasterController {

    @Autowired
    IOrderDestinationService orderDestinationService;

    @Autowired
    IOrderStatusService orderStatusService;

    @Autowired
    IOrderMasterService orderMasterService;

    OrderMasterImpl form;
    List<OrderDestination> orderdestinations = null;
    List<OrderStatus> orderstatus = null;

    class OrderMasterImpl extends ke.novia.view.pos.sale.OrderMaster {

        public OrderMasterImpl(Frame parent, boolean modal) {
            super(parent, modal);
            if (orderdestinations != null && orderdestinations.size() > 0) {
                JComboBox lo = new JComboBox();
                for (OrderDestination orderdestination : orderdestinations) {
                    lo.addItem(orderdestination);
                }
                orderdestination_id.setModel(lo.getModel());
            }
            if (orderstatus != null && orderstatus.size() > 0) {
                JComboBox lo = new JComboBox();
                for (OrderStatus orderStatus : orderstatus) {
                    lo.addItem(orderStatus);
                }
                orderstatus_id.setModel(lo.getModel());
            }

            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());

            orderdatetime.setText(timeStamp);

            btnsubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ke.novia.model.pos.sale.OrderMaster ordermaster = new ke.novia.model.pos.sale.OrderMaster();
                    //menu.setId(0);
                    //orderMaster.setId(0);
                    ordermaster.setOrderdestination((OrderDestination) orderdestination_id.getSelectedItem());
                    ordermaster.setOrderno(orderno.getText());
                    ordermaster.setTableno(tableno.getText());
                    ordermaster.setOrderdatetime(null);

                    ordermaster.setNotes(notes.getText());
                    orderMasterService.save(ordermaster);
                    if (ordermaster.getId() > 0) {
                        JOptionPane.showMessageDialog(OrderMasterImpl.this, "Order Saved");
                    } else {
                        JOptionPane.showMessageDialog(OrderMasterImpl.this, "Error");
                    }

                    //call orderform
                  
                }
            });
        }
    }

    public OrderMasterController() {

    }

    public void openOrderMasterWindow(JFrame parent) {
        orderdestinations = orderDestinationService.findAll();
        orderstatus = orderStatusService.findAll();

        form = new OrderMasterImpl(parent, true);
        form.setVisible(true);
    }

}
