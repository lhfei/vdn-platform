/**
 * 
 */
Ext.define('hwork.view.FileStatusGrid', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.fileStatusGrid',
	
	frame: false,
	autoWidth: true,
	autoHeight: true,
	
	fixed: true,
	border: 1,
	style: {
	    //borderColor: 'red',
	    borderStyle: 'solid'
	},
	
	title: 'HDFS 文件列表',
	store: 'FileStatusStore',
	
	//selType: 'checkboxmodel',
    columns: [
        {header: '序号', xtype: 'rownumberer', width: 40, sortable: false, locked: true }, 
        {header: 'ID',  dataIndex: 'fileId',  flex: 1, align: 'center', hidden: true},
        {header: 'Permission', dataIndex: 'permission', flex: 1, align: 'center'},
        {header: 'Owner', dataIndex: 'owner', flex: 1, align: 'center'},
        {header: 'Size', dataIndex: 'length', flex: 2, align: 'center'},
        {header: 'Replication', dataIndex: 'replication', flex: 1, align: 'center'},
        {header: 'Block Size', dataIndex: 'blockSize', flex: 1, align: 'center'},
        
        {header: 'Name', dataIndex: 'pathSuffix', flex: 2, align: 'center', 
        	renderer: function(val) { return '<a href="#">' +val+ '</a>' },
        },
        
        {header: 'accessTime', dataIndex: 'accessTime', flex: 2, align: 'center'},
        {header: 'modificationTime', dataIndex: 'modificationTime', flex: 2, align: 'center'},
        
       /* {
        	header: '作业状态', 
        	dataIndex: 'status', 
        	flex: 1, 
        	align: 'center',
        	renderer: function(val) {
        		switch(val) {
        		
        		case 0:
        			return '<span style="color:red;">未提交</span>';
        			break;
        			
        		case 1: 
        			return '<span style="color:green;">待审核 </span>';
        			break;

        		case 2:
        			return '<span style="color:blue;">已审核</span>';
        			break;
        			
        		case 3: 
        			return '<span style="color:red;">未通过</span>';
        			break;
        		}
        	}
        	
        },{
            xtype: 'actioncolumn',
            id: 'ctrlCell',
            flex: 1,
            header: '作业状态',
            align: 'center',
            sortable: false,
            menuDisabled: true,
            items: [{
            	xtype: 'button',
            	id: 'startCtrl',
                iconCls: 'icon-upload',
                tooltip: '上传作业附件',
                action: 'start',
                hidden: true,
                scope: this
            },'-',{
            	xtype: 'button',
            	id: 'startCtrl',
                iconCls: 'icon-download',
                tooltip: '预览作业附件',
                action: 'start',
                scope: this
            }]
        },*/
        
        
        {header: 'type', dataIndex: 'type', flex: 1, align: 'center', hidden: true},
        {header: 'childrenNum', dataIndex: 'childrenNum', flex: 1, align: 'center', hidden: true},
        {header: 'storagePolicy', dataIndex: 'storagePolicy', flex: 1, align: 'center', hidden: true},
        {header: 'group', dataIndex: 'group', flex: 1, align: 'center', hidden: true}

    ],
    
    initComponent: function() {
		this.dockedItems = [{
            xtype: 'pagingtoolbar',
            dock:'bottom',
            store: 'FileStatusStore',
            displayInfo: true,
            displayMsg: 'Displaying records {2}',
            emptyMsg: "No records to display"
        }];
		
		this.tbar = ['-',{
            xtype:'button',
            text: '当前位置:',
            id: '0_',
            action: 'doHistory',
            iconCls: 'icon-folder'
        }, '-']
		
		this.callParent(arguments);
	}
    
});