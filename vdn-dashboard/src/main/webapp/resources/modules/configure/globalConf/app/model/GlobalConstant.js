/**
 * 
 */
Ext.define('ifeng.model.GlobalConstant', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    {name: 'url', mapping: 'hdfs.HDFS_URL'},
	    {name: 'webUrl', mapping: 'hdfs.WEBHDFS_DEFAULT_URL'}
	]
	
});