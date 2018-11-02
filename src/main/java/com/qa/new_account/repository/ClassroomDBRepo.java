package com.qa.new_account.repository;


	import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.Query;
	import javax.transaction.Transactional;

import com.qa.Util.JSONUtil;
import com.qa.new_account.domain.ClassRoom;

	@Transactional
	@Default
	public class ClassroomDBRepo implements ClassRoomRepo {
		
		
		@Inject
		private JSONUtil util;
		@PersistenceContext(unitName="primary")
		private EntityManager manager;
		
		
		public String getAllRooms() {
			Query query = manager.createQuery("Select a FROM Room a");
			Collection<ClassRoom> AccList = (Collection<ClassRoom>) query.getResultList();
			return util.getJSONForObject(AccList);
		
		}
			
			@Transactional
		
		public String addRoom(String ClassRoom) {

			ClassRoom acc1=util.getObjectForJSON (ClassRoom, ClassRoom.class);
			manager.persist(acc1);
			return "{\"message\":\"Account Added\"}";
		}
		
			@Transactional
			public String deleteRoom(Long Id) {
				ClassRoom accountInDB = findRoom(Id);
				if (accountInDB != null) {
					manager.remove(accountInDB);
				}
				
				return "{\"message\": \"movie sucessfully deleted\"}";
			
			}
			
			@Transactional
			public String updateRoom(Long Id, String roomToUpdate) {
				 ClassRoom updatedRoom = util.getObjectForJSON(roomToUpdate, ClassRoom.class);
				ClassRoom roomFromDB = findRoom(Id);
				if (roomToUpdate != null) {
					roomFromDB = updatedRoom;
					manager.merge(roomFromDB);
				}
				return "{\"message\": \"account sucessfully updated\"}";
			}
			
			
			
			public String getRoom(Long Id) {
				ClassRoom acc1 =  manager.find(ClassRoom.class, Id);
				return util.getJSONForObject(acc1);
			}

			private ClassRoom  findRoom(Long Id) {
				return manager.find(ClassRoom.class, Id);
			}

			public void setManager(EntityManager manager) {
				this.manager = manager;
			}

			public void setUtil(JSONUtil util) {
				this.util = util;
			}

			

		



			

		}


