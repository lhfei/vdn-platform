/**
 * 
 */
Ext.define('hwork.model.FileStatus', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
		'accessTime',
		'modificationTime',
		'blockSize',
		'childrenNum' ,
		'fileId' ,
		'group' ,
		'length' ,
		'owner' ,
		'pathSuffix' ,
		'permission' ,
		'replication',
		'storagePolicy',
		'type'
	]
	
});